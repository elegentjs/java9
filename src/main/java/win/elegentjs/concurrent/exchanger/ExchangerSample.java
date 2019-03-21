package win.elegentjs.concurrent.exchanger;

import java.util.concurrent.Exchanger;

/**
 * 演示Exchanger，可以在线程间进行通信
 *
 * 注意：非第一个线程在执行exchange方法时会阻塞，等待对方的线程传递过来的exchange数据
 */
public class ExchangerSample {

    public static void main(String[] args) throws InterruptedException {
        A a = new A();
        Exchanger<String> exchanger = new Exchanger<>();

        new Thread(() -> {
            a.a(exchanger);
        }).start();

        new Thread(() -> {
            a.a(exchanger);
        }).start();

        Thread.sleep(3000);

        new Thread(() -> {
            a.b(exchanger);
        }).start();
    }
}


class A {

    public void a(Exchanger<String> exchanger) {
        System.out.println(Thread.currentThread().getName() + " running...");

        try {
            String result = exchanger.exchange("hello world. ");
            System.out.println("a result : " + result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void b(Exchanger<String> exchanger) {
        System.out.println(Thread.currentThread().getName() + " running...");

        try {
            String result = exchanger.exchange("java concurrent.");
            System.out.println("b result : " + result);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
