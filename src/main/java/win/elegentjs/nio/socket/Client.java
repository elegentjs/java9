package win.elegentjs.nio.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class Client {

    private SocketChannel socketChannel;

    private Selector selector;

    private ByteBuffer send = ByteBuffer.allocate(1024);

    private ByteBuffer rece = ByteBuffer.allocate(1024);


    public Client(String hostName, Integer serverPort) throws IOException {
        selector = Selector.open();
        socketChannel = SocketChannel.open();
        socketChannel.socket().connect(new InetSocketAddress(hostName, serverPort));
        socketChannel.configureBlocking(false);

        System.out.println("与服务器连接成功！");
    }


    public void start() throws IOException {
        socketChannel.register(selector, SelectionKey.OP_READ | SelectionKey.OP_WRITE);

        while (selector.select() > 0) {
            for (Iterator<SelectionKey> iterator = selector.selectedKeys().iterator(); iterator.hasNext(); ) {
                SelectionKey key = null;

                try {
                    key = iterator.next();
                    iterator.remove();

                    if (key.isReadable()) {
                        handleRead(key);
                    }

                    if (key.isWritable()) {
                        handleWrite(key);
                    }
                } catch (Exception e) {
                    key.cancel();
                    key.channel().close();
                }
            }
        }

    }

    private void handleWrite(SelectionKey key) throws IOException {
        SocketChannel channel = (SocketChannel) key.channel();

        synchronized (send) {
            send.flip();
            channel.write(send);
            send.compact();
        }

    }

    private void handleRead(SelectionKey key) throws IOException {
        SocketChannel channel = (SocketChannel) key.channel();
        channel.read(rece);
        rece.flip();
        String msg = CharSetUtil.decode(rece, "UTF-8");

        if (!msg.contains("\r\n")) {
            return;
        }

        String outPutData = msg.substring(0, msg.indexOf("\n") + 1);
        System.out.println(outPutData);

        if ("echo:bye\r\n".equalsIgnoreCase(outPutData)) {
            key.cancel();
            channel.close();
            selector.close();
            System.out.println("关闭与服务端的连接");
        }

        ByteBuffer tmp = CharSetUtil.encode(outPutData, "UTF-8");
        rece.position(tmp.limit());
        rece.compact();
    }

    private void sendMsg() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String msg = null;
        while ((msg = bufferedReader.readLine()) != null) {
            synchronized (send) {
                send.put(CharSetUtil.encode(msg + "\r\n", "UTF-8"));
            }
            if ("bye".equalsIgnoreCase(msg)) {
                break;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Client client = new Client("localhost", 9000);

        new Thread(() -> {
            try {
                client.sendMsg();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();

        client.start();
    }
}
