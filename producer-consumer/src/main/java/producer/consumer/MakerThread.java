package producer.consumer;

/**
 * @author jiangyang
 * @date 2022/6/2 15:29
 */
public class MakerThread extends Thread {

    private final Table table;
    private static int id = 0;

    public MakerThread(Table table) {
        super("maker");
        this.table = table;
    }

    @Override
    public void run() {
        while (true) {
            try {
                table.put("cake-" + nextId());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private synchronized int nextId() {
        return id++;
    }

}
