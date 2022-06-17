package lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @author jiangyang
 * @date 2022/6/3 23:47
 */
public class CustomLock implements Lock {

    private boolean isLocked = false;
    private Thread hold;
    private int holdCount;

    @Override
    public void lock() {
        synchronized (this) {
            while (isLocked && hold != Thread.currentThread()) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            isLocked = true;
            hold = Thread.currentThread();
            holdCount++;
        }
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
    public void unlock() {
        synchronized (this) {
            if (hold == Thread.currentThread()) {
                holdCount--;
                if (holdCount == 0) {
                    isLocked = false;
                    this.notifyAll();
                }
            }
        }
    }

    @Override
    public Condition newCondition() {
        return null;
    }
}
