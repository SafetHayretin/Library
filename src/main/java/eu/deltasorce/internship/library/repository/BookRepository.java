package eu.deltasorce.internship.library.repository;

import eu.deltasorce.internship.library.model.book.Author;
import eu.deltasorce.internship.library.model.book.Book;

import java.util.ArrayList;
import java.util.List;

public final class BookRepository {

    private static List<Book> books = new ArrayList<>();

    public static boolean add(Book book) {
        return books.add(book);
    }

    public static boolean deleteById(int index) {
        Book book = books.get(index);
        return books.remove(book);
    }

    public static boolean deleteByName(String title) {
        for (Book book : books) {
            if (title.equals(book.getBookTitle())) {
                return books.remove(book);
            }
        }
        return false;
    }

    public static Book getBook(Author author) {
        for (Book book : books) {
            if (author.equals(book.getAuthor())) {
                return book;
            }
        }
        return null;
    }

    public static int numberOfBooks() {
        return books.size();
    }

    public static void clear() {
        books.clear();
    }
}
