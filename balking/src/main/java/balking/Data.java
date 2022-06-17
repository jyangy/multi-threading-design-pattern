package balking;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * @author jiangyang
 * @date 2022/6/2 14:08
 */
public class Data {

    private final String fileName;
    private String content;
    private boolean changed;

    public Data(String fileName) {
        this.fileName = fileName;
    }

    public synchronized void change(String content) {
        this.content = content;
        this.changed = true;
    }

    public synchronized void save() throws IOException {
        if (!changed) {
            return;
        }
        doSave();
        changed = false;
    }

    private void doSave() throws IOException {
        System.out.println(Thread.currentThread().getName() + " do save, content = " + content);
        Writer writer = new FileWriter(fileName);
        writer.write(content);
        writer.close();
    }

}
