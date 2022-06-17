package single.threaded.execution;

/**
 * @author jiangyang
 * @date 2022/5/31 10:53
 */
public class Main {

    public static void main(String[] args) {

        // SharedResource
        Gate gate = new Gate();

        new UserThread(gate,"Alice", "American").start();
        new UserThread(gate,"Chen", "China").start();
        new UserThread(gate,"TT", "Thailand").start();
    }

}
