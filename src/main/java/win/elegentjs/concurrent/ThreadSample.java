package win.elegentjs.concurrent;

/**
 * 演示了线程的两种创建方式：
 *  1）继承Thread类
 *  2）重写Runnable方法（推荐）
 *
 *  演示类join的作用：主线程会等待子线程执行完毕才会继续执行
 */
public class ThreadSample {

    public static void main(String[] args) throws InterruptedException {
        SimpleThread simpleThread = new SimpleThread();
        simpleThread.start();
        simpleThread.join();

        new Thread(() -> System.out.println("Thread name : " + Thread.currentThread().getName())).start();

    }
}


class SimpleThread extends Thread {
    @Override
    public void run() {
        System.out.println("thread name : " + Thread.currentThread().getName());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}