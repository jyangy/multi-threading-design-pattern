package guarded.suspension;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author jiangyang
 * @date 2022/6/2 10:07
 */
public class RequestQueue3 {

    private final Queue<Request> queue = new LinkedList<>();
    private final ReentrantLock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();

    public Request getRequest() {
        try {
            lock.lock();
            while (queue.peek() == null) {
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } finally {
            lock.unlock();
        }
        return queue.remove();
    }

    public void putRequest(Request request) {
        try {
            lock.lock();
            queue.offer(request);
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }
}
