package win.elegentjs.concurrent;

@SuppressWarnings("all")
public class ThreadSample {
    public static void main(String[] args) {
        System.out.println("main Thread Name: " + Thread.currentThread().getName());


        for (int index  = 0; index < 10; index ++) {
            new Thread(() -> System.out.println("Thread Name: " + Thread.currentThread().getName()), index + "").start();
        }

    }
}
