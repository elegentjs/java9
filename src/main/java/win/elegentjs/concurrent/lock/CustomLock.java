package win.elegentjs.concurrent.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * 自定义Lock，以理解Lock的基本原理
 * 并创建了可重入性锁
 */
public class CustomLock implements Lock {

    private boolean isLocked;

    private Thread lockedBy;

    private int lockedCount;

    @Override
    public synchronized void lock() {
        while (isLocked && lockedBy != Thread.currentThread()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        lockedBy = Thread.currentThread();
        isLocked = true;
        lockedCount ++;
    }

    @Override
    public synchronized void unlock() {
        if (lockedBy == Thread.currentThread()) {
            lockedCount --;

            if (lockedCount == 0) {
                isLocked = false;
            }
        }

        isLocked = false;
        notifyAll();
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }



    @Override
    public Condition newCondition() {
        return null;
    }
}





