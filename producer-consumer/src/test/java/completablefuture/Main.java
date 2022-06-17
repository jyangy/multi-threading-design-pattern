package completablefuture;

import java.util.concurrent.CompletableFuture;

/**
 * @author jiangyang
 * @date 2022/6/6 15:03
 */
public class Main {

    public static void main(String[] args) {

        // run
        CompletableFuture.runAsync(() -> System.out.println(Thread.currentThread().getName()));

        // supply
        // Supplier Function Consumer
        CompletableFuture.supplyAsync(() -> "hello world")
                .thenApply(String::toUpperCase)
                .thenAccept(System.out::println);

        // thenCompose
        CompletableFuture.supplyAsync(() -> "hello world")
                .thenCompose(result -> CompletableFuture.supplyAsync(result::toUpperCase))
                .thenAccept(System.out::println);


        // thenCombine
        CompletableFuture.supplyAsync(() -> 500)
                .thenCombine(CompletableFuture.supplyAsync(() -> 300), Integer::sum)
                .thenAccept(System.out::println);


    }

}
