package win.elegentjs.concurrent;

import java.io.IOException;
import java.util.concurrent.*;

public class ExecutorServiceSample {

    public static void main(String[] args) throws IOException {

        BlockingQueue<Runnable> blockingQueue = new ArrayBlockingQueue<>(3);
        blockingQueue.add(() -> System.out.println(Thread.currentThread().getName()));

        ExecutorService executorService = new ThreadPoolExecutor(1, 10, 1000, TimeUnit.MILLISECONDS, blockingQueue);


        executorService.submit(() -> null);

        executorService.shutdown();

    }
}
