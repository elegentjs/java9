package win.elegentjs.concurrent.lock;

@SuppressWarnings("all")
public class LockSample {

    private Lock lock = new Lock();

    private int total;

    public void doSynchronized() throws InterruptedException {
        lock.lock();

        Thread.sleep(10 * (int) Math.random() * 10);
        System.out.println("Thread: " + Thread.currentThread().getName() + ", total: " + total ++);

        lock.unlock();
    }

    public static void main(String[] args) {
        LockSample sample = new LockSample();

        Runnable r = () -> {
            try {
                sample.doSynchronized();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        for (int index = 0; index < 100; index ++) {
            new Thread(r , "" + index).start();
        }

    }





}


class Lock {
    private boolean isLocked = false;

    private Thread lockingThread;

    public synchronized void lock() throws InterruptedException {
        while (isLocked) {
            wait();
        }

        isLocked = true;

        lockingThread = Thread.currentThread();
    }


    public synchronized void unlock() {
        if (this.lockingThread != Thread.currentThread()) {
            throw new IllegalMonitorStateException("calling thread has not locked this lock");
        }

        isLocked = false;
        lockingThread = null;

        notify();
    }

}
