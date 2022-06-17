package blockingqueue;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jiangyang
 * @date 2022/6/4 21:52
 */
public class BlockingQueue {

    private final List<String> list = new ArrayList<>();
    private final int limit;

    public BlockingQueue(int limit) {
        this.limit = limit;
    }

    public synchronized void enqueue(String s) throws InterruptedException {
        while (list.size() == limit) {
            System.out.println("full queue");
            wait();
        }
        list.add(s);
        notifyAll();
    }

    public synchronized String dequeue() throws InterruptedException {
        while (list.size() == 0) {
            System.out.println("empty queue");
            wait();
        }
        notifyAll();
        return list.remove(0);
    }

}
