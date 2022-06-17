import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/**
 * @author jiangyang
 * @date 2022/6/3 18:03
 */
public class Main {

    public static void main(String[] args) {

//        Object monitor = new Object();
//        AtomicInteger i = new AtomicInteger(0);
//        new EventThread(monitor, i).start();
//        new OddThread(monitor, i).start();

        int a = -3;
        byte[] data = new byte[2];
        data[1] = (byte) ((a >> 8) & 0xff);
        data[0] = (byte) (a & 0xff);

        ByteBuffer buffer = ByteBuffer.wrap(data);
        buffer.order(ByteOrder.LITTLE_ENDIAN);
        System.out.println(buffer.getShort());

        System.out.println(data[0] & 0xff | (data[1] << 8));
        System.out.println(data[1] << 8);
        System.out.println((data[1] & 0xff) << 8);

    }

}
