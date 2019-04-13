package win.elegentjs.netty.first.client;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        for(int index = 0; index < 100; index ++) {
            executorService.submit(() -> {
                try {
                    new EchoClient("127.0.0.1", 9999).start();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
    }
}
