package win.elegentjs.io;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

@SuppressWarnings("all")
public class PipeSample {
    public static void main(String[] args) throws IOException {
        PipedOutputStream pipedOutputStream = new PipedOutputStream();
        PipedInputStream pipedInputStream = new PipedInputStream(pipedOutputStream);

        Thread t = new Thread(() -> {
            try {
                pipedOutputStream.write("Hello World, pipe!".getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        });


        Thread t2 = new Thread(() -> {
            try {

                int data = pipedInputStream.read();

                while (data != -1) {
                    System.out.print((char) data);
                    data = pipedInputStream.read();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        });


        t.start();
        t2.start();

    }
}
