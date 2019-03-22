package win.elegentjs.net.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
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
        executorService.execute(new ReadThread(socket));
        executorService.execute(new WriteThread(socket));
    }

}



