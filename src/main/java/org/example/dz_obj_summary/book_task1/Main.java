package org.example.dz_obj_summary.book_task1;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Book book1 = new Book("Mark", "Trash", 2222);
        Book book2 = new Book("Mark", "Trash", 222);

        List<Book> books = new ArrayList<>();
        books.add(book1);
        books.add(book2);

        System.out.println(books);

        if (book1.equals(book2)) {
            System.out.println("Они равны");
            System.out.println(book1.hashCode());
            System.out.println(book2.hashCode());
        } else {
            System.out.println("Они не равны");
            System.out.println(book1.hashCode());
            System.out.println(book2.hashCode());
        }

        if (book1.hashCode() == book2.hashCode()) {
            System.out.println("Равны по хэш-коду");
        } else {
            System.out.println("Различны по хэш-коду");
        }

    }
}