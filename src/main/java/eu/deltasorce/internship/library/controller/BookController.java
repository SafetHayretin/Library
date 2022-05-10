package eu.deltasorce.internship.library.controller;

import eu.deltasorce.internship.library.model.book.Book;
import eu.deltasorce.internship.library.service.BookService;

public class BookController {
    private final BookService service = new BookService();

    public Book searchByAuthorName(String name) {
        return service.searchByAuthorName(name);
    }

    public boolean addOnlineBook(String title, String authorName, String genre, String summary, String readLink) {
        return service.addOnlineBook(title, authorName, genre, summary, readLink);
    }

    public boolean addPaperBook(String title, String authorName, String genre, String summary, String isbn, int total) {
        return service.addPaperBook(title, authorName, genre, summary, isbn, total);
    }

    public boolean deleteBookById(int index) {
        return service.deleteById(index);
    }

    public boolean deleteBookByName(String title) {
        return service.deleteByName(title);
    }
}
