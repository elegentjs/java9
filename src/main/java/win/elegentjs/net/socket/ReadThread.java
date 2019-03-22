package win.elegentjs.net.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class ReadThread implements Runnable {

    private Socket socket;

    public ReadThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            InputStream inputStream = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));

            while (true) {
                System.out.println("收到消息： " + br.readLine());
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
