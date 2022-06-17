package guarded.suspension;

/**
 * @author jiangyang
 * @date 2022/6/2 10:11
 */
public class ClientThread extends Thread {

    private RequestQueue requestQueue;

    public ClientThread(RequestQueue requestQueue) {
        super("client");
        this.requestQueue = requestQueue;
    }

    @Override
    public void run() {
        Request request;
        for (int i = 0; i < 10000; i++) {
            request = new Request("request-" + i);
            requestQueue.putRequest(request);
            System.out.println("client thread requests " + request);
        }
    }
}
