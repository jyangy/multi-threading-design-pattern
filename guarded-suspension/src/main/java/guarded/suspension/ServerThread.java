package guarded.suspension;

/**
 * @author jiangyang
 * @date 2022/6/2 10:09
 */
public class ServerThread extends Thread {

    private RequestQueue requestQueue;

    public ServerThread(RequestQueue requestQueue) {
        super("server");
        this.requestQueue = requestQueue;
    }

    @Override
    public void run() {
        while (true) {
            Request request = requestQueue.getRequest();
            System.out.println("server thread handles " + request);
        }
    }
}
