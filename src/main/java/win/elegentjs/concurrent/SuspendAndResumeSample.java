package win.elegentjs.concurrent;

@SuppressWarnings("all")
public class SuspendAndResumeSample {

    public static void main(String[] args) throws InterruptedException {
        TestObject o = new TestObject();

        Thread t1 = new Thread(() -> o.print(), "A");
        t1.start();
        Thread.sleep(1000);


        Thread t2 = new Thread(() -> {
            System.out.println("B已启动，但进不到print方法中");
            o.print();
        }, "B");

        t2.start();

    }
}


class TestObject {
    public synchronized void print() {
        if (Thread.currentThread().getName().equals("A")) {
            System.out.println("A 线程独占资源");
            Thread.currentThread().suspend();
        }
    }
}