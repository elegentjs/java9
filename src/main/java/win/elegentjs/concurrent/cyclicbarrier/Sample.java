package win.elegentjs.concurrent.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 演示CyclicBarrier的使用
 *
 * CyclicBarrier表示循环屏障
 *
 */
public class Sample {

    public static void main(String[] args) {
        Meeting meeting = new Meeting();
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, () -> {
            System.out.println("开始开会了。 Thread ： " + Thread.currentThread().getName());
        });

        new Thread(() -> {meeting.display(cyclicBarrier);}).start();
        new Thread(() -> {meeting.display(cyclicBarrier);}).start();
        new Thread(() -> {meeting.display(cyclicBarrier);}).start();

    }

}


class Meeting {

    public void display(CyclicBarrier cyclicBarrier) {
        System.out.println("Thread : " + Thread.currentThread().getName());
        try {
            Thread.sleep((long)(Math.random() * 1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
