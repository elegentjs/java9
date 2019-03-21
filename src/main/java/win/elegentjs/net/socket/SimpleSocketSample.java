package win.elegentjs.net.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimpleSocketSample {
    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        Server server = new Server(5000);
        executorService.execute(server::start);

        System.out.println("server listening on port 5000.");

    }
}



class Server {

    private int port;

    private Socket socket;

    public Server(int port) {
        this.port = port;
    }

    public void start() {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);
            socket = serverSocket.accept();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                }
            }
        }
    }


    public void display() {

    }
}


class Client {

    private Socket socket;

    public void Conn() {
        try {
            socket = new Socket("localhost", 5000);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void send(String msg) {
        try {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            bw.write(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
