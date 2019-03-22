package win.elegentjs.net.socket.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketAddress;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 基于UDP传输协议的服务端
 */
public class ServerMain {

    public static void main(String[] args) {
        ChatServer chatServer = new ChatServer(5000);
        chatServer.start();
    }

}

class ChatServer {
    private ExecutorService executorService = Executors.newFixedThreadPool(10);

    private DatagramSocket datagramSocket;

    public ChatServer(int port) {

        try {
            datagramSocket = new DatagramSocket(port);
            System.out.println("server started on port : " + port);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    /**
     * 开启服务端读写线程
     */
    public void start() {

        while (true) {
            byte[] receiveData = new byte[1024];
            DatagramPacket packet = new DatagramPacket(receiveData, receiveData.length);
            try {
                datagramSocket.receive(packet);
            } catch (IOException e) {
                e.printStackTrace();
            }

            executorService.execute(new RWThread(packet));
        }

    }

    class RWThread implements Runnable {

        private DatagramPacket datagramPacket;

        public RWThread(DatagramPacket datagramPacket) {
            this.datagramPacket = datagramPacket;
        }

        @Override
        public void run() {
            System.out.println("收到： " + new String(datagramPacket.getData()));
            SocketAddress socketAddress = datagramPacket.getSocketAddress();

            byte[] msg = "hello, 我是服务端".getBytes();
            DatagramPacket sendPacket = new DatagramPacket(msg, msg.length, socketAddress);

            // 5.向客户端发送消息
            DatagramSocket mSocket = null;
            try {
                mSocket = new DatagramSocket();
                mSocket.send(sendPacket);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
