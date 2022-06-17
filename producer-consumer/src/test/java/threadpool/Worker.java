package threadpool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author jiangyang
 * @date 2022/6/6 11:33
 */
public class Worker implements Runnable {

    private final String name;
    private final BlockingQueue<Runnable> tasks;

    public Worker(String name, BlockingQueue<Runnable> tasks) {
        this.name = name;
        this.tasks = tasks;
    }

    public String getName() {
        return name;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Runnable task = tasks.poll(5, TimeUnit.SECONDS);
                if (null != task) {
                    task.run();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
