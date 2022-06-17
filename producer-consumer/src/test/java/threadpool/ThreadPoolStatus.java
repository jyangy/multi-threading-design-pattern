package threadpool;

/**
 * @author jiangyang
 * @date 2022/6/6 11:35
 */
public enum ThreadPoolStatus {

    RUNNING;

    public boolean isRunning() {
        return RUNNING.equals(this);
    }

}
