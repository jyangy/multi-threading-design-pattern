package producer.consumer;

/**
 * @author jiangyang
 * @date 2022/6/2 15:33
 */
public class EaterThread extends Thread {

    private final Table table;

    public EaterThread(Table table) {
        super("eater");
        this.table = table;
    }

    @Override
    public void run() {
        while (true) {
            try {
                table.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
