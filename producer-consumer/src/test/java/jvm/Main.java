package jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jiangyang
 * @date 2022/6/11 16:46
 */
public class Main {

    static class Book {
    }

    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
        while (true) {
            books.add(new Book());
        }
    }

}
