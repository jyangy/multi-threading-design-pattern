package read.write.lock;

/**
 * @author jiangyang
 * @date 2022/6/15 21:52
 */
public class Main {

    public static void main(String[] args) {
        Data data = new Data();
        new WriteThread(data).start();
        new ReadThread(data).start();
    }

}
