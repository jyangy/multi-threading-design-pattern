package single.threaded.execution;

/**
 * @author jiangyang
 * @date 2022/5/31 10:47
 */
public class Gate {

    private int counter = 0;
    private String name = "";
    private String address = "";

    public synchronized void pass(String name, String address) {
        this.counter++;
        this.name = name;
        this.address = address;
        check();
    }

    private void check() {
        if (name.charAt(0) != address.charAt(0)) {
            System.out.println("BROKEN " + this);
        }
    }

    @Override
    public synchronized String toString() {
        return this.counter + " " + this.name + " " + this.address;
    }

}
