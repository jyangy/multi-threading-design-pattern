package read.write.lock;

/**
 * @author jiangyang
 * @date 2022/6/15 21:16
 */
public class WriteThread extends Thread {

    private Data data;

    public WriteThread(Data data) {
        this.data = data;
    }

    @Override
    public void run() {
        while (true) {
            data.write();
        }
    }
}
