package win.elegentjs.concurrent.condition;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionSample {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        E e = new E();

        executorService.submit(() -> {
            while (true) {
                e.a();
                Thread.sleep(1000);
            }
        });

        executorService.submit(() -> {
            while (true) {
                e.b();
                Thread.sleep(1000);
            }
        });

        executorService.submit(() -> {
            while (true) {
                e.c();
                Thread.sleep(1000);
            }
        });
    }
}


class E {

    private int signal = 0;
    private Lock lock = new ReentrantLock();
    private Condition a = lock.newCondition();
    private Condition b = lock.newCondition();
    private Condition c = lock.newCondition();

    public void a() {
        lock.lock();

        while (signal != 0) {
            try {
                a.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        signal ++;
        b.signal();
        System.out.println("a");

        lock.unlock();
    }


    public void b() {
        lock.lock();

        while (signal != 1) {
            try {
                b.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        signal ++;
        c.signal();
        System.out.println("b");

        lock.unlock();
    }

    public void c() {
        lock.lock();

        while (signal != 2) {
            try {
                c.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        signal = 0;
        a.signal();
        System.out.println("c");

        lock.unlock();
    }
}