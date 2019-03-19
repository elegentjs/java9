package win.elegentjs.concurrent.basic;

/**
 * 模拟死锁的情况
 *
 * 第一个线程持有第一个对象锁，同时它需要另一个对象锁
 * 第二个正好相反，持有第二个对象锁，同时它需要第一个对象锁
 *
 * 此时就会造成死锁
 *
 */
public class DeadLockSample {
    private static Object a = new Object();
    private static Object b = new Object();

    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (a) {
                System.out.println("1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (b) {
                    System.out.println("2");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();




        new Thread(() -> {
            synchronized (b) {
                System.out.println("3");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (a) {
                    System.out.println("4");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
