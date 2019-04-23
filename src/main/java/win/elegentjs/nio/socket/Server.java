package win.elegentjs.nio.socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class Server {

    // 暴露服务端口
    private Integer port;

    // 服务端Socket通道
    private ServerSocketChannel serverSocketChannel;

    // 选择器
    private Selector selector;

    public Server(Integer port) throws IOException {
        this.port = port;

        this.selector = Selector.open();

        this.serverSocketChannel = ServerSocketChannel.open();

        serverSocketChannel.socket().setReuseAddress(true);
        serverSocketChannel.socket().bind(new InetSocketAddress(port));
        serverSocketChannel.configureBlocking(false);

        System.out.println("服务器启动成功！");
    }

    public void start() throws IOException {
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        // 当所有通道中都都无事件时阻塞
        while (selector.select() > 0) {
            Set<SelectionKey> keys = selector.selectedKeys();

            for (Iterator<SelectionKey> iterator = keys.iterator(); iterator.hasNext(); ) {
                SelectionKey key = null;
                try {
                    key = iterator.next();
                    iterator.remove();

                    if (key.isAcceptable()) {
                        handleAccept(key);
                    }

                    if (key.isReadable()) {
                        handleRead(key);
                    }

                    if (key.isWritable()) {
                        handleWrite(key);
                    }
                } catch (Exception e) {
                    if (key != null) {
                        key.cancel();
                        key.channel().close();
                    }
                }

            }
        }

    }

    private void handleWrite(SelectionKey key) throws IOException {
        ByteBuffer buffer = (ByteBuffer) key.attachment();
        SocketChannel channel = (SocketChannel) key.channel();
        buffer.flip();

        String msg = CharSetUtil.decode(buffer, "UTF-8");

        if (!msg.contains("\r\n")) {
            return;
        }

        String outPutData = msg.substring(0, msg.indexOf("\n") + 1);
        System.out.println("接收来自客户端的数据：" + outPutData);

        ByteBuffer outbyteBuffer = CharSetUtil.encode("echo:" + outPutData, "UTF-8");
        while (outbyteBuffer.hasRemaining()) {
            channel.write(outbyteBuffer);
        }

        ByteBuffer tmp = CharSetUtil.encode(outPutData, "UTF-8");
        buffer.position(tmp.limit());
        buffer.compact();
        if ("bye\r\n".equalsIgnoreCase(outPutData)) {
            key.cancel();
            channel.close();
            System.out.println("关闭与客户端的连接");
        }
    }


    private void handleRead(SelectionKey key) throws IOException {
        ByteBuffer buffer = (ByteBuffer) key.attachment();
        SocketChannel channel = (SocketChannel) key.channel();
        ByteBuffer readBuffer = ByteBuffer.allocate(32);
        channel.read(readBuffer);
        readBuffer.flip();

        buffer.limit(buffer.capacity());
        buffer.put(readBuffer);
    }


    private void handleAccept(SelectionKey key) throws IOException {
        ServerSocketChannel channel = (ServerSocketChannel) key.channel();
        SocketChannel socketChannel = channel.accept();

        System.out.println("接收到来自： " + socketChannel.socket().getInetAddress() + ", 端口： " + socketChannel.socket().getPort() + " 的请求。");
        socketChannel.configureBlocking(false);

        socketChannel.register(selector, SelectionKey.OP_READ | SelectionKey.OP_WRITE, ByteBuffer.allocate(1024));
    }


    public static void main(String[] args) throws IOException {
        new Server(9000).start();
    }
}
