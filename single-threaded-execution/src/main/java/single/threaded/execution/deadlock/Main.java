package single.threaded.execution.deadlock;

/**
 * @author jiangyang
 * @date 2022/5/31 13:59
 */
public class Main {

    public static void main(String[] args) {

        Tool fork = new Tool("fork");
        Tool spoon = new Tool("spoon");

        new EatThread("Alice", fork, spoon).start();
        new EatThread("Bob", spoon, fork).start();

    }

}
