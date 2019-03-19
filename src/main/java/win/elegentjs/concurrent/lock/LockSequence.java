package win.elegentjs.concurrent.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用Lock实现线程同步
 */
public class LockSequence {

    public static void main(String[] args) {
        Sequence s  = new Sequence();

        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " : " + s.next());
            }
        }).start();

        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " : " + s.next());
            }
        }).start();


    }
}



class Sequence {
    private Integer val = 0;
    private Lock lock = new CustomLock();

    public Integer next() {
        lock.lock();
        int a = val ++;
        lock.unlock();
        return a;
    }
}