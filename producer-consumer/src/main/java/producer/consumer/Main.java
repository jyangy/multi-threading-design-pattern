package producer.consumer;

/**
 * @author jiangyang
 * @date 2022/6/2 15:34
 */
public class Main {

    public static void main(String[] args) {

        Table table = new Table(3);
        new MakerThread(table).start();
        new MakerThread(table).start();
        new MakerThread(table).start();
        new EaterThread(table).start();

    }

}
