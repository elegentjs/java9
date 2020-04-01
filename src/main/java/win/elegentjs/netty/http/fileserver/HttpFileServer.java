package win.elegentjs.netty.http.fileserver;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.*;
import io.netty.handler.stream.ChunkedFile;
import io.netty.handler.stream.ChunkedWriteHandler;
import io.netty.util.CharsetUtil;

import java.io.File;
import java.io.RandomAccessFile;

public class HttpFileServer {

    private static final String PATH = "/Users/liupeijun/Downloads";

    public void run(int port) throws Exception {
        EventLoopGroup boss = new NioEventLoopGroup();
        EventLoopGroup worker = new NioEventLoopGroup();

        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group(boss, worker)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel channel) throws Exception {
                            channel.pipeline()
                                    .addLast("http-decoder", new HttpRequestDecoder())
                                    .addLast("http-aggregator", new HttpObjectAggregator(65536))
                                    .addLast("http-encoder", new HttpResponseEncoder())

                                    // 支持异步发送大的码流（如大文件传输）
                                    .addLast("http-chunked", new ChunkedWriteHandler())
                                    .addLast("fileServerHandler", new HttpFileServerHandler());
                        }
                    });

            ChannelFuture f = b.bind(port).sync();

            System.out.println("http file server started on port: " + port);

            f.channel().closeFuture().sync();

        } finally {
            boss.shutdownGracefully();
            boss.shutdownGracefully();
        }
    }

    public static void main(String[] args) throws Exception {
        new HttpFileServer().run(8080);

    }

    public static class HttpFileServerHandler extends SimpleChannelInboundHandler<FullHttpRequest> {


        @Override
        protected void channelRead0(ChannelHandlerContext ctx, FullHttpRequest req) {
            if (req.method() != HttpMethod.GET) {
                sendError(ctx, HttpResponseStatus.METHOD_NOT_ALLOWED);
                return;
            }

            // 文件的相对路径
            String uri = req.uri();


            File file = new File(PATH + uri);
            if (file.exists()) {
                if (file.isDirectory()) {
                    if (uri.endsWith("/")) {
                        sendListing(ctx, file);
                    } else {
                        sendRedirect(ctx, uri + "/");
                    }
                } else {
                    transferFile(file, ctx);
                }
            } else {
                sendError(ctx, HttpResponseStatus.NOT_FOUND);
            }
        }


        /**
         * 传输文件
         *
         * @param file
         * @param ctx
         */
        private void transferFile(File file, ChannelHandlerContext ctx) {
            try {
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
                long fileLength = randomAccessFile.length();
                HttpResponse response = new DefaultHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK);
                response.headers().set(HttpHeaderNames.CONTENT_LENGTH, fileLength);
                ctx.write(response);
                ChannelFuture sendFileFuture = ctx.write(new ChunkedFile(randomAccessFile, 0, fileLength, 8192), ctx.newProgressivePromise());
                addListener(sendFileFuture);
                ChannelFuture lastContentFuture = ctx.writeAndFlush(LastHttpContent.EMPTY_LAST_CONTENT);
                lastContentFuture.addListener(ChannelFutureListener.CLOSE);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        /**
         * 监听传输状态
         */
        private void addListener(ChannelFuture sendFileFuture) {
            sendFileFuture.addListener(new ChannelProgressiveFutureListener() {
                @Override
                public void operationComplete(ChannelProgressiveFuture future) {
                    System.out.println("Transfer complete.");
                }

                @Override
                public void operationProgressed(ChannelProgressiveFuture future, long progress, long total) throws Exception {
                    if (total < 0) {
                        System.out.println("Transfer progress: " + progress);
                    } else {
                        System.out.println("Transfer progress: " + progress + "/" + total);
                    }
                }
            });
        }


        /**
         * 跳转链接
         */
        private static void sendRedirect(ChannelHandlerContext ctx, String newUri) {
            // 302 redirect
            FullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.FOUND);
            response.headers().set(HttpHeaderNames.LOCATION, newUri);
            ctx.writeAndFlush(response).addListener(ChannelFutureListener.CLOSE);
        }

        /**
         * 请求为目录时，显示文件列表
         */
        private static void sendListing(ChannelHandlerContext ctx, File dir) {
            FullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK);

            response.headers().set(HttpHeaderNames.CONTENT_TYPE, "text/html;charset=UTF-8");

            String dirPath = dir.getPath();
            StringBuilder buf = new StringBuilder();

            buf.append("<!DOCTYPE html>\r\n");
            buf.append("<html><head><title>");
            buf.append(dirPath);
            buf.append("目录:");
            buf.append("</title></head><body>\r\n");

            buf.append("<h3>");
            buf.append(dirPath).append(" 目录：");
            buf.append("</h3>\r\n");
            buf.append("<ul>");
            buf.append("<li>链接：<a href=\" ../\")..</a></li>\r\n");
            for (File f : dir.listFiles()) {
                if (f.isHidden() || !f.canRead()) {
                    continue;
                }
                String name = f.getName();
            /*if (!ALLOWED_FILE_NAME.matcher(name).matches()) {
                continue;
            }*/
                buf.append("<li>链接：<a href=\"");
                buf.append(name);
                buf.append("\">");
                buf.append(name);
                buf.append("</a></li>\r\n");
            }
            buf.append("</ul></body></html>\r\n");
            ByteBuf buffer = Unpooled.copiedBuffer(buf, CharsetUtil.UTF_8);
            response.content().writeBytes(buffer);
            buffer.release();
            ctx.writeAndFlush(response).addListener(ChannelFutureListener.CLOSE);

        }

        /**
         * 失败响应
         */
        private static void sendError(ChannelHandlerContext ctx, HttpResponseStatus status) {
            FullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, status, Unpooled.copiedBuffer("Failure: " + status.toString() + "\r\n", CharsetUtil.UTF_8));

            response.headers().set(HttpHeaderNames.CONTENT_TYPE, "text/html;charset=UTF-8");
            ctx.writeAndFlush(response).addListener(ChannelFutureListener.CLOSE);
        }
    }
}
