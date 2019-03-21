package win.elegentjs.concurrent.semaphore;

import java.util.concurrent.Semaphore;

/**
 * 演示Semaphore的使用
 *
 * 作用： 可以控制同时并发的线程数量
 *
 */
public class SemaphoreSample {

    public static void main(String[] args) {

        D d = new D();
        Semaphore semaphore = new Semaphore(10);

        while (true) {
            new Thread(() -> {d.display(semaphore);}).start();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}



class D {


    public void display(Semaphore semaphore) {
        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + " is Running .");
        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        semaphore.release();
    }

}
