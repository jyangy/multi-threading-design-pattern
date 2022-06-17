package lock;

/**
 * @author jiangyang
 * @date 2022/6/3 23:55
 */
public class Main {

    public static void main(String[] args) {
        CustomLock lock = new CustomLock();
        for (int i = 0; i < 100; i++) {
            int finalI = i;
            new Thread(() -> {
                lock.lock();
                System.out.println(finalI);
                lock.unlock();
            }).start();
        }
    }

}
