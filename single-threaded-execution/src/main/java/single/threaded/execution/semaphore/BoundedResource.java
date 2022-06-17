package single.threaded.execution.semaphore;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author jiangyang
 * @date 2022/5/31 11:34
 */
public class BoundedResource {

    private final int permits;
    private final Semaphore semaphore;

    public BoundedResource(int permits) {
        this.permits = permits;
        this.semaphore = new Semaphore(permits);
    }

    public void use() {
        try {
            semaphore.acquire();
            doUse();
        } catch (Exception e) {

        } finally {
            semaphore.release();
        }
    }

    private void doUse() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " BEGIN used:" + (permits - semaphore.availablePermits()));
        TimeUnit.SECONDS.sleep(1);
        System.out.println(Thread.currentThread().getName() + " END used:" + (permits - semaphore.availablePermits()));
    }

}
