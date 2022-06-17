package threadlocal;

import java.util.concurrent.TimeUnit;

/**
 * @author jiangyang
 * @date 2022/6/6 10:48
 */
public class Main {

    public static void main(String[] args) {
        ThreadLocal<String> threadLocal = new ThreadLocal<>();

        new Thread(() -> threadLocal.set("hello world")).start();

        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(threadLocal.get());
        }).start();
    }

}
