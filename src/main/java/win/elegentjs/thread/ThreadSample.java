package win.elegentjs.thread;

/**
 * 演示了线程的两种创建方式：
 *  1）继承Thread类
 *  2）重写Runnable方法（推荐）
 */
public class ThreadSample {

    public static void main(String[] args) throws InterruptedException {
        new SimpleThread().start();

        new Thread(() -> System.out.println("Thread name : " + Thread.currentThread().getName())).start();

    }
}



class SimpleThread extends Thread {
    @Override
    public void run() {
        System.out.println("thread name : " + Thread.currentThread().getName());
    }
}