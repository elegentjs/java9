package win.elegentjs.concurrent.lock;

import java.util.ArrayList;
import java.util.List;

public class FairLockSample {
    private  FairLock lock = new FairLock();

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


class FairLock {
    private boolean isLocked = false;
    private Thread lockingThread = null;
    private List<QueueObject> waitingThreads = new ArrayList<>();

    public void lock() throws InterruptedException {
        QueueObject queueObject = new QueueObject();
        boolean isLockedForThisThread = true;

        synchronized (this) {
            waitingThreads.add(queueObject);
        }

        while (isLockedForThisThread) {
            synchronized (this) {
                isLockedForThisThread = isLocked || waitingThreads.get(0) != queueObject;

                if (!isLockedForThisThread) {
                    isLocked = true;
                    waitingThreads.remove(queueObject);
                    lockingThread = Thread.currentThread();
                    return;
                }
            }


            try {
                queueObject.doWait();
            } catch (InterruptedException e) {
                synchronized (this) {
                    waitingThreads.remove(queueObject);
                }
                throw e;
            }
        }
    }



    public synchronized void unlock() {
        if (this.lockingThread != Thread.currentThread()) {
            throw new IllegalMonitorStateException("Calling thread has not locked this lock");
        }

        isLocked = false;
        lockingThread = null;

        if (waitingThreads.size() > 0) {
            waitingThreads.get(0).doNotify();
        }
    }

}



class QueueObject {
    private boolean isNotified = false;

    public synchronized void doWait() throws InterruptedException {
        while (!isNotified) {
            this.wait();
        }

        this.isNotified = false;
    }


    public synchronized void doNotify() {
        this.isNotified = true;
        this.notify();
    }




}