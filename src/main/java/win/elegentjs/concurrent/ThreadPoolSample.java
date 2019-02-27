package win.elegentjs.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ThreadPoolSample {


    public static void main(String[] args) throws InterruptedException {
        ThreadPool pool = new ThreadPool(10, 100);

        Runnable runnable = () -> System.out.println(Thread.currentThread().getName());

        for (int index = 0; index < 100; index ++) {
            pool.execute(runnable);
        }

        pool.stop();

    }

}


class ThreadPool {
    private BlockingQueue<Runnable> taskQueue;
    private List<PoolThread> threadList = new ArrayList<>();
    private boolean isStopped = false;

    public ThreadPool(int threads, int maxTasks) {
        taskQueue = new ArrayBlockingQueue<>(maxTasks);

        for (int i = 0; i < threads; i++) {
            threadList.add(new PoolThread(taskQueue));
        }

        for (PoolThread thread : threadList) {
            thread.start();
        }

    }

    public synchronized void execute(Runnable task) throws InterruptedException {
        if(isStopped) {
            throw new IllegalStateException("ThreadPool is stopped");
        }

        taskQueue.put(task);
    }

    public synchronized boolean stop() {
        isStopped = true;

        for (PoolThread thread : threadList) {
            thread.toStop();
        }

        return true;
    }
}


class PoolThread extends Thread {

    private BlockingQueue<Runnable> taskQueue;
    private boolean isStopped;

    public PoolThread(BlockingQueue<Runnable> queue) {
        taskQueue = queue;
    }

    @Override
    public void run() {
        while (!isStopped()) {
            Runnable runnable = null;
            try {
                runnable = taskQueue.take();
                runnable.run();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }


    public synchronized boolean isStopped() {
        return isStopped;
    }

    public synchronized void toStop() {
        isStopped = true;
        this.interrupt();
    }
}
