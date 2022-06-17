package exchanger;

import java.util.concurrent.Exchanger;

/**
 * @author jiangyang
 * @date 2022/6/6 09:59
 */
public class Main {

    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();
        new Thread(() -> {
            try {
                String exchange = exchanger.exchange(Thread.currentThread().getName() + " fuck");
                System.out.println(exchange);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }).start();

        new Thread(() -> {
            try {
                String exchange = exchanger.exchange(Thread.currentThread().getName() + " you");
                System.out.println(exchange);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
