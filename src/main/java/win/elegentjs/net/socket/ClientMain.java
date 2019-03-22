package win.elegentjs.net.socket;

import java.io.*;
import java.net.Socket;
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

    private Socket socket;

    public ChatClient(int port) {
        try {
            socket = new Socket("127.0.0.1", port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void start() {
        executorService.submit(new ReadThread());
        executorService.submit(new WriteThread());
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
                        System.out.println("收到消息： " + line);
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

                    System.out.print("发送至服务端： ");
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