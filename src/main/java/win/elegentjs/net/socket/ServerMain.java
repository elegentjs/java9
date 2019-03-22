package win.elegentjs.net.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerMain {
    public static void main(String[] args) {

        ChatServer chatServer = new ChatServer(5000);
        chatServer.start();
    }
}



class ChatServer {

    private ExecutorService executorService = Executors.newFixedThreadPool(10);

    private Socket socket;

    public ChatServer(int port) {

        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("server started on port : " + port);
            socket = serverSocket.accept();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 开启服务端读写线程
     */
    public void start() {
        executorService.execute(new ReadThread());
        executorService.execute(new WriteThread());
    }


    private class ReadThread implements Runnable {

        @Override
        public void run() {
            while (true) {
                try {
                    InputStream inputStream = socket.getInputStream();
                    BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));

                    String line;
                    while ((line = br.readLine()) != null) {
                        System.out.println("客户端消息： " + line);
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private class WriteThread implements Runnable {

        @Override
        public void run() {
            while (true) {
                try {
                    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                    System.out.print("往客户端发送消息： ");
                    Scanner scanner = new Scanner(System.in);
                    String line = scanner.nextLine();

                    bw.write(line);
                    bw.flush();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}



