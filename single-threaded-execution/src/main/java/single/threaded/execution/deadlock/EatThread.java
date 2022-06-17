package single.threaded.execution.deadlock;

/**
 * @author jiangyang
 * @date 2022/5/31 13:54
 */
public class EatThread extends Thread {

    private final String name;
    private final Tool leftHand;
    private final Tool rightHand;

    public EatThread(String name, Tool leftHand, Tool rightHand) {
        this.name = name;
        this.leftHand = leftHand;
        this.rightHand = rightHand;
    }

    @Override
    public void run() {
        while (true) {
            eat();
        }
    }

    private void eat() {
        synchronized (leftHand) {
            System.out.println(name + "'s left hand takes up " + leftHand);
            synchronized (rightHand) {
                System.out.println(name + "'s right hand takes up " + rightHand);
                System.out.println(name + " is eating");
                System.out.println(name + "'s right hand puts down " + rightHand);
            }
            System.out.println(name + "'s left hand puts down " + leftHand);
        }
    }

}
