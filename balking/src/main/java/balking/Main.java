package balking;

/**
 * @author jiangyang
 * @date 2022/6/2 14:22
 */
public class Main {

    public static void main(String[] args) {
        Data data = new Data("/Users/jiangyang/Desktop/data");
        new ServerThread(data).start();
        new ClientThread(data).start();
    }

}
