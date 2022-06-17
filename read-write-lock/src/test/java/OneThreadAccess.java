import java.util.concurrent.atomic.AtomicLong;

/**
 * @author jiangyang
 * @date 2022/6/16 09:13
 */
public class OneThreadAccess {

    private final AtomicLong current = new AtomicLong(-1);

    public void acquire() {
        long id = Thread.currentThread().getId();
        if (id != current.get() && !current.compareAndSet(-1, id)) {
            throw new RuntimeException("only one thread access");
        }
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        OneThreadAccess oneThreadAccess = new OneThreadAccess();
        new Thread(oneThreadAccess::acquire).start();
        new Thread(oneThreadAccess::acquire).start();
        new Thread(oneThreadAccess::acquire).start();
        new Thread(oneThreadAccess::acquire).start();
        new Thread(oneThreadAccess::acquire).start();
    }

}
