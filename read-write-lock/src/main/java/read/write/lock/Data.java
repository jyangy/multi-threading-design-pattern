package read.write.lock;

/**
 * @author jiangyang
 * @date 2022/6/15 21:49
 */
public class Data {

    private ReadWriteLock readWriteLock = new ReadWriteLock();

    public void read() {
        readWriteLock.readLock();
        try {
            System.out.println("+++ " + Thread.currentThread().getName() + " read");
        } finally {
            readWriteLock.readUnLock();
        }
    }

    public void write() {
        readWriteLock.writeLock();
        try {
            System.out.println("--- " + Thread.currentThread().getName() + " write");
        } finally {
            readWriteLock.writeUnLock();
        }
    }

}
