package win.elegentjs.concurrent.condition;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 演示使用wait&notify实现线程的顺序执行
 */
public class WaitNotifySample {

    public static void main(String[] args) {
        S s = new S();

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        executorService.submit(() -> {
            while (true) {
                s.a();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        executorService.submit(() -> {
            while (true) {
                s.b();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        executorService.submit(() -> {
            while (true) {
                s.c();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}



class S {
    private int signal = 0;

    public synchronized void a() {
        while (signal != 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        signal ++;
        System.out.println("a");
        notifyAll();
    }

    public synchronized void b() {
        while (signal != 1) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        signal ++;
        System.out.println("b");
        notifyAll();
    }

    public synchronized void c() {
        while (signal != 2) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        signal = 0;
        System.out.println("c");
        notifyAll();
    }
}


