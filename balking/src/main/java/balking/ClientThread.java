package balking;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author jiangyang
 * @date 2022/6/2 14:19
 */
public class ClientThread extends Thread {

    private final Data data;

    public ClientThread(Data data) {
        super("client");
        this.data = data;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            try {
                data.change("content-" + i);
                TimeUnit.SECONDS.sleep(new Random().nextInt(5));
                data.save();
            } catch (InterruptedException | IOException e) {
                e.printStackTrace();
            }
        }
    }
}
