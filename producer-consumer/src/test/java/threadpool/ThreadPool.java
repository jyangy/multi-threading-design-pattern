package threadpool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;

/**
 * @author jiangyang
 * @date 2022/6/6 11:31
 */
public class ThreadPool {

    private final BlockingQueue<Runnable> task;
    private final List<Worker> workers = new ArrayList<>();
    private final ThreadPoolStatus threadPoolStatus;

    public ThreadPool(int workerNum, BlockingQueue<Runnable> task) {
        this.task = task;
        for (int i = 0; i < workerNum; i++) {
            workers.add(new Worker("worker-" + i, task));
        }
        for (Worker worker : workers) {
            new Thread(worker, worker.getName()).start();
        }
        threadPoolStatus = ThreadPoolStatus.RUNNING;
    }

    public boolean execute(Runnable runnable) {
        if (!threadPoolStatus.isRunning()) {
            throw new RuntimeException("thread pool is not running");
        }
        return task.offer(runnable);
    }

    public static void main(String[] args) {
        int COUNT_BITS = Integer.SIZE - 3;
        int CAPACITY   = (1 << COUNT_BITS) - 1;
        System.out.println(Integer.toBinaryString(CAPACITY));
    }
}
