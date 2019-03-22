package win.elegentjs.net.socket;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class WriteThread implements Runnable {

    private Socket socket;

    public WriteThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            PrintWriter pw = new PrintWriter(bw, true);
            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.print("发送消息：");
                pw.println(scanner.nextLine());
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

