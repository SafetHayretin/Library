package eu.deltasorce.internship.library.repository;

import eu.deltasorce.internship.library.model.book.Book;

import java.util.ArrayList;
import java.util.List;

public class BookRepo {
    private static List<Book> books = new ArrayList<>();

    public static void addBook(Book book) {
        books.add(book);
    }

    public static void deleteBook(Book book) {
        books.remove(book);
    }

}
