package eu.deltasorce.internship.library.repository;

import eu.deltasorce.internship.library.model.book.Book;

import java.util.ArrayList;
import java.util.List;

public class BookRepository {

    private static List<Book> books = new ArrayList<>();

    public static boolean addBook(Book book) {
        return books.add(book);
    }

    public static boolean deleteBook(Book book) {
        return books.remove(book);
    }

    public static boolean deleteById(int index) {
        Book book = books.get(index);
        return books.remove(book);
    }

    public static int numberOfBooks() {
        return books.size();
    }

    public static void clear() {
        books.clear();
    }
}
