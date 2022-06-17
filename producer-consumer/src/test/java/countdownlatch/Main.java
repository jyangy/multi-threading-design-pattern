package countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * @author jiangyang
 * @date 2022/6/4 12:34
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(2);

        new Thread(() -> System.out.println("hello world"), "t1").start();
        new Thread(countDownLatch::countDown, "t2").start();
        new Thread(countDownLatch::countDown, "t3").start();

        countDownLatch.await();
        System.out.println("all ready");
    }

}
