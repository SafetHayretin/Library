package eu.deltasorce.internship.library.controller;

import eu.deltasorce.internship.library.model.book.Book;
import eu.deltasorce.internship.library.model.book.OnlineBook;
import eu.deltasorce.internship.library.model.book.PaperBook;
import eu.deltasorce.internship.library.service.BookService;

import java.util.List;

public class BookController {

    private final BookService service = new BookService();

    public List<Book> searchByAuthorName(String name) {
        if(name == null || name.isBlank()){
            throw new IllegalArgumentException("Wrong input for searching");
        }
        return service.searchByAuthorName(name);
    }

    public List<Book> searchByTitle(String title) {
        if(title == null || title.isBlank()){
            throw new IllegalArgumentException("Wrong input for searching");
        }
        return service.searchByTitle(title);
    }

    public List<Book> searchByGenre(String genre) {
        if(genre == null || genre.isBlank()){
            throw new IllegalArgumentException("Wrong input for searching");
        }
        return service.searchByGenre(genre);
    }

    public String readBookOnline(String isbn) {
        if(isbn == null || isbn.isBlank()){
            throw new IllegalArgumentException("Wrong input for reading online");
        }
        return service.readBookOnline(isbn);
    }

    public String downloadBook(String isbn) {
        if(isbn == null || isbn.isBlank()){
            throw new IllegalArgumentException("Wrong input for downloading");
        }
        return service.downloadBook(isbn);
    }

    public boolean addOnlineBook(OnlineBook book) {
        if(book == null){
            throw new IllegalArgumentException("Nothing was passed");
        }
        return service.addOnlineBook(book);
    }

    public boolean addPaperBook(PaperBook book) {
        if(book == null){
            throw new IllegalArgumentException("Nothing was passed");
        }
        return service.addPaperBook(book);
    }

    public boolean deleteBookByIsbn(String isbn) {
        if(isbn == null || isbn.isBlank()){
            throw new IllegalArgumentException("Wrong input for downloading");
        }
        return service.deleteByIsbn(isbn);
    }

}
