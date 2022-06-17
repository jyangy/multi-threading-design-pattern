package threadpool;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author jiangyang
 * @date 2022/6/6 11:43
 */
public class Main {

    public static void main(String[] args) {
        ThreadPool threadPool = new ThreadPool(10, new LinkedBlockingQueue<>());
        for (int i = 0; i < 1000; i++) {
            threadPool.execute(() -> System.out.println(Thread.currentThread().getName() + " execute task"));
        }
    }

}
