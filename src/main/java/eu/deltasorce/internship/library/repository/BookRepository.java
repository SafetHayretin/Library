package eu.deltasorce.internship.library.repository;

import eu.deltasorce.internship.library.model.book.Author;
import eu.deltasorce.internship.library.model.book.Book;
import eu.deltasorce.internship.library.model.book.OnlineBook;

import java.util.ArrayList;
import java.util.List;

public final class BookRepository {

    private static final List<Book> books = new ArrayList<>();

    public static boolean add(Book book) {
        return books.add(book);
    }

    public static boolean deleteByIsbn(String isbn) {
        for (Book book : books) {
            if (isbn.equals(book.getIsbn())) {
                return books.remove(book);
            }
        }
        return false;
    }

    /**
     * Goes through book repository to find books with given author
     * @param author Author of the searched book
     * @return List of books in book repository with given author
     */
    public static List<Book> getBooksByAuthor(Author author) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (author.equals(book.getAuthor())) {
                result.add(book);
            }
        }
        return result;
    }

    /**
     * Goes through book repository to find books with given title
     *
     * @param title Title of the searched books
     * @return List of books in book repository with given title
     */
    public static List<Book> getBooksByTitle(String title) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (title.equals(book.getTitle())) {
                result.add(book);
            }
        }
        return result;
    }

    /**
     * Goes through book repository to find books with given genre
     *
     * @param genre Genre of the searched books
     * @return List of books in book repository with given genre
     */
    public static List<Book> getBooksByGenre(String genre) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (genre.equals(book.getGenre())) {
                result.add(book);
            }
        }
        return result;
    }

    /**
     * Separates online books from all books
     *
     * @return List of all online books
     */
    public static List<OnlineBook> findOnlineBooks() {
        List<OnlineBook> onlineBooks = new ArrayList<>();
        for (Book book : books) {
            if (book instanceof OnlineBook) {
                onlineBooks.add((OnlineBook) book);
            }
        }
        return onlineBooks;
    }

    public static int numberOfBooks() {
        return books.size();
    }

    public static void clear() {
        books.clear();
    }
}
