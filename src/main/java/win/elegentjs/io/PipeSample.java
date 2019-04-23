package win.elegentjs.io;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SuppressWarnings("all")
public class PipeSample {
    public static void main(String[] args) throws IOException {
        PipedOutputStream pipedOutputStream = new PipedOutputStream();
        PipedInputStream pipedInputStream = new PipedInputStream(pipedOutputStream);

        ExecutorService  executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        executorService.submit(() -> {
            try {
                pipedOutputStream.write("Hello World, pipe!".getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        });


        executorService.submit(() -> {
            try {
                int data = pipedInputStream.read();

                while (data != -1) {
                    System.out.print((char) data);
                    data = pipedInputStream.read();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }  finally {
                try {
                    pipedOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    pipedInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });

        executorService.shutdown();

    }
}
