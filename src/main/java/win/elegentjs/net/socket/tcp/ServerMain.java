package win.elegentjs.net.socket.tcp;

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

    private ServerSocket serverSocket;

    public ChatServer(int port) {

        try {
            serverSocket = new ServerSocket(port);
            System.out.println("server started on port : " + port);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    /**
     * 开启服务端读写线程
     * 支持多客户端连入
     */
    public void start() {

        while (true) {
            try {
                Socket socket = serverSocket.accept();
                executorService.execute(new ReadThread(socket));
                executorService.execute(new WriteThread(socket));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}



