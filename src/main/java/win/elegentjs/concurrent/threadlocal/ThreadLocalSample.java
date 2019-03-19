package win.elegentjs.concurrent.threadlocal;

@SuppressWarnings("all")
public class ThreadLocalSample {

    private static ThreadLocal<Integer> integerThreadLocal = ThreadLocal.withInitial(() -> 100);

    public void add(Integer i) {
        integerThreadLocal.set(integerThreadLocal.get() + i);
    }


    public void display() {
        System.out.println("value : " + integerThreadLocal.get());
    }


    public static void main(String[] args) {
        ThreadLocalSample sample = new ThreadLocalSample();

        Thread t1 = new Thread(() -> {
            System.out.println("in Thread1.");
            sample.add(10);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            sample.display();
        });


        Thread t2 = new Thread(() -> {
            System.out.println("in thread2");
            sample.add(10);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            sample.display();
        });

        t1.start();
        t2.start();
    }


}
