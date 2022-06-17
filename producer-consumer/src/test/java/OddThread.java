import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author jiangyang
 * @date 2022/6/3 17:59
 */
public class OddThread extends Thread {

    private final Object monitor;
    private final AtomicInteger i;

    public OddThread(Object monitor, AtomicInteger i) {
        super("odd");
        this.monitor = monitor;
        this.i = i;
    }

    @Override
    public void run() {
        synchronized (monitor) {
            while (i.get() <= 100 && i.get() % 2 != 0) {
                monitor.notifyAll();
                try {
                    System.out.println(Thread.currentThread().getName() + " " + i.getAndIncrement());
                    monitor.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
