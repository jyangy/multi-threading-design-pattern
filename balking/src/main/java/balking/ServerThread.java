package balking;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @author jiangyang
 * @date 2022/6/2 14:13
 */
public class ServerThread extends Thread {

    private final Data data;

    public ServerThread(Data data) {
        super("server");
        this.data = data;
    }

    @Override
    public void run() {
        while (true) {
            try {
                data.save();
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException | IOException e) {
                e.printStackTrace();
            }

        }
    }
}
