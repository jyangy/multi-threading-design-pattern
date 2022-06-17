package producer.consumer;

/**
 * @author jiangyang
 * @date 2022/6/2 15:20
 */
public class Table {

    private final String[] cakes;
    private int head;
    private int tail;
    // 计数
    private int count;

    public Table(int maxCount) {
        this.cakes = new String[maxCount];
        this.head = 0;
        this.tail = 0;
        this.count = 0;
    }

    public synchronized void take() throws InterruptedException {
        while (count <= 0) {
            wait();
        }
        String cake = cakes[head];
        System.out.println(Thread.currentThread().getName() + " takes " + cake + " off the table");
        head = (head + 1) % cakes.length;
        count--;
        notifyAll();
    }

    public synchronized void put(String cake) throws InterruptedException {
        while (count >= cakes.length) {
            wait();
        }
        System.out.println(Thread.currentThread().getName() + " puts " + cake + " on the table");
        cakes[tail] = cake;
        tail = (tail + 1) % cakes.length;
        count++;
        notifyAll();
    }
}
