package read.write.lock;

/**
 * @author jiangyang
 * @date 2022/6/15 21:16
 */
public class ReadThread extends Thread {

    private Data data;

    public ReadThread(Data data) {
        this.data = data;
    }

    @Override
    public void run() {
        while (true) {
            data.read();
        }
    }

}
