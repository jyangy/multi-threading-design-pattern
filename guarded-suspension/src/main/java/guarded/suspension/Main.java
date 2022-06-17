package guarded.suspension;

/**
 * @author jiangyang
 * @date 2022/6/2 10:12
 */
public class Main {

    public static void main(String[] args) {
        RequestQueue requestQueue = new RequestQueue();
        new ServerThread(requestQueue).start();
        new ClientThread(requestQueue).start();

    }
}
