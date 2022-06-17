package single.threaded.execution.deadlock;

/**
 * @author jiangyang
 * @date 2022/5/31 13:51
 */
public class Tool {

    private final String name;

    public Tool(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "[" + name + "]";
    }
}
