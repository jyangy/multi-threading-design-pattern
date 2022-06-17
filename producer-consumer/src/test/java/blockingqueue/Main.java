package blockingqueue;

/**
 * @author jiangyang
 * @date 2022/6/4 21:56
 */
public class Main {

    public static void main(String[] args) {
        BlockingQueue blockingQueue = new BlockingQueue(3);
        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                try {
                    blockingQueue.enqueue(String.valueOf(i));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(() -> {
            while (true) {
                try {
                    System.out.println(Thread.currentThread().getName() + " consume " + blockingQueue.dequeue());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(() -> {
            while (true) {
                try {
                    System.out.println(Thread.currentThread().getName() + " consume " + blockingQueue.dequeue());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

}
