package read.write.lock;

/**
 * @author jiangyang
 * @date 2022/6/15 21:16
 */
public class ReadWriteLock {

    private int readingReaders;
    private int writingWriters;

    public synchronized void readLock() {
        while (writingWriters > 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        readingReaders++;
    }

    public synchronized void readUnLock() {
        readingReaders--;
        notifyAll();
    }

    public synchronized void writeLock() {
        while (readingReaders > 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        writingWriters++;
    }

    public synchronized void writeUnLock() {
        writingWriters--;
        notifyAll();
    }

}
