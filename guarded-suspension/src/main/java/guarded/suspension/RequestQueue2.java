package guarded.suspension;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author jiangyang
 * @date 2022/6/2 10:07
 */
public class RequestQueue2 {

    private final BlockingQueue<Request> queue = new LinkedBlockingDeque<>();

    public Request getRequest() {
        Request request = null;
        try {
            request = queue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return request;
    }

    public void putRequest(Request request) {
        try {
            queue.put(request);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
