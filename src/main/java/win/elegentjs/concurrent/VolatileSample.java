package win.elegentjs.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 演示volatile
 */
public class VolatileSample {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Demo demo = new Demo();

        executorService.submit(() -> {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            demo.setVal(10);});

        executorService.submit(() -> {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("val: " + demo.getVal());
        });

        Thread.sleep(200);
        System.out.println("final val : " + demo.getVal());

        System.out.println("=========================================");
        Demo2 demo2 = new Demo2();
        executorService.submit(() -> {
            demo2.setVal(10);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        executorService.submit(() -> {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("val: " + demo2.getVal());
        });

        Thread.sleep(200);
        System.out.println("final val : " + demo.getVal());


        executorService.shutdown();
    }

}


class Demo {
    private volatile int val = 1;

    public synchronized int getVal() {
        return val;
    }

    public synchronized void setVal(int val) {
        this.val = val;
    }
}


class Demo2 {
    private volatile int val = 1;

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }
}
