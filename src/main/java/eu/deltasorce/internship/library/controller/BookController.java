package eu.deltasorce.internship.library.controller;

import eu.deltasorce.internship.library.model.book.Book;
import eu.deltasorce.internship.library.service.BookService;

import java.util.List;

public class BookController {

    private final BookService service = new BookService();

    public List<Book> searchByAuthorName(String name) {
        return service.searchByAuthorName(name);
    }

    public List<Book> searchByTitle(String title) {
        return service.searchByTitle(title);
    }

    public List<Book> searchByGenre(String genre) {
        return service.searchByGenre(genre);
    }

    public String readBookOnline(String isbn) {
        return service.readBookOnline(isbn);
    }

    public String downloadBook(String isbn) {
        return service.downloadBook(isbn);
    }

    public boolean addOnlineBook(String title, String authorName, String genre, String summary, String isbn, String readLink, String downloadLink) {
        return service.addOnlineBook(title, authorName, genre, summary, isbn, readLink, downloadLink);
    }

    public boolean addPaperBook(String title, String authorName, String genre, String summary, String isbn, int total) {
        return service.addPaperBook(title, authorName, genre, summary, isbn, total);
    }

    public boolean deleteBookByIsbn(String isbn) {
        return service.deleteByIsbn(isbn);
    }

}
