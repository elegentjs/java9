package win.elegentjs.net.socket.tcp;

import java.io.IOException;
import java.net.Socket;
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
        executorService.submit(new ReadThread(socket));
        executorService.submit(new WriteThread(socket));
    }
}



