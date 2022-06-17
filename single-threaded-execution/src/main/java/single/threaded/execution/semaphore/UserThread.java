package single.threaded.execution.semaphore;

import java.util.concurrent.TimeUnit;

/**
 * @author jiangyang
 * @date 2022/5/31 11:39
 */
public class UserThread extends Thread {

    private BoundedResource boundedResource;

    public UserThread(BoundedResource boundedResource) {
        this.boundedResource = boundedResource;
    }

    @Override
    public void run() {
        while (true) {
            boundedResource.use();
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {

            }
        }
    }
}
