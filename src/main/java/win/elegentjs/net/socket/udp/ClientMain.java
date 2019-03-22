package win.elegentjs.net.socket.udp;

import java.net.*;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ClientMain {

    public static void main(String[] args) {
        ChatClient chatClient = new ChatClient(5000);

        chatClient.start();

    }
}


class ChatClient {

    private ExecutorService executorService = Executors.newFixedThreadPool(10);

    private int port;

    public ChatClient(int port) {
        this.port = port;
    }


    /**
     * 开启读写线程
     */
    public void start() {
        // 写线程
        executorService.execute(new WriteThread());

        // 读线程
        executorService.execute(new ReadThread());

    }

    class ReadThread implements Runnable {

        @Override
        public void run() {
            Scanner scanner = new Scanner(System.in);

            while (true) {
                byte[] receiveData = new byte[1024];
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);

                // 5.接收服务端消息
                DatagramSocket mSocket = null;
                try {
                    mSocket = new DatagramSocket();

                    mSocket.receive(receivePacket);

                    System.out.println("收到： " + new String(receiveData));


                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }
    }


    class WriteThread implements Runnable {

        @Override
        public void run() {
            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.print("发送：");
                byte[] msg = scanner.nextLine().getBytes();
                DatagramPacket receivePacket = new DatagramPacket(msg, msg.length, new InetSocketAddress("127.0.0.1", port));

                // 5.向服务端发送消息
                DatagramSocket mSocket = null;
                try {
                    mSocket = new DatagramSocket();
                    mSocket.send(receivePacket);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
