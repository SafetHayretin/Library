package eu.deltasorce.internship.library.service;

import eu.deltasorce.internship.library.model.book.Author;
import eu.deltasorce.internship.library.model.book.Book;
import eu.deltasorce.internship.library.model.book.OnlineBook;
import eu.deltasorce.internship.library.model.book.PaperBook;
import eu.deltasorce.internship.library.repository.BookRepository;

import java.util.List;

public class BookService {

    AuthorService service = new AuthorService();

    /**
     * First gets author from repository searching by name
     * Then creates book without download link
     * If download link is given adds it to book
     * @param readLink Link where you can read book online
     * @param downloadLink Link where you can download book for free
     * @return true/false if book is added to repository or failed
     */
    public boolean addOnlineBook(String name, String authorName, String genre, String summary, String isbn, String readLink, String downloadLink) {
        Author author = service.getAuthorFromRepository(authorName);
        OnlineBook book = new OnlineBook(name, author, genre, summary, isbn, readLink);
        if (downloadLink != null) {
            book.setDownloadLink(downloadLink);
        }
        return BookRepository.add(book);
    }

    /**
     * Created book and adds it to repository
     * Sets book available count equal to total count
     * @param total Copies of paper book
     * @return true/false if book is added to repository or failed
     */
    public boolean addPaperBook(String name, String authorName, String genre, String summary, String isbn, int total) {
        Author author = service.getAuthorFromRepository(authorName);
        Book book = new PaperBook(name, author, genre, summary, isbn, total, total);
        return BookRepository.add(book);
    }

    public boolean deleteByIsbn(String isbn) {
        return BookRepository.deleteByIsbn(isbn);
    }

    /**
     * First gets all online books from repository
     * Goes through all online books and checks for book with same title
     * @return Link where book can be read
     */
    public String readBookOnline(String title) {
        List<OnlineBook> onlineBooks = BookRepository.onlineBooks();
        for (OnlineBook book : onlineBooks) {
            if (title.equals(book.getTitle())) {
                return book.getReadLink();
            }
        }
        return null;
    }

    /**
     * First gets all online books from repository
     * Goes through all online books and checks for book with same title
     * @return Link where book can be downloaded
     */
    public String downloadBook(String title) {
        List<OnlineBook> onlineBooks = BookRepository.onlineBooks();
        for (OnlineBook book : onlineBooks) {
            if (title.equals(book.getTitle())) {
                return book.getDownloadLink();
            }
        }
        return null;
    }

    public List<Book> searchByAuthorName(String name) {
        Author author = service.getAuthorFromRepository(name);
        return BookRepository.getBooksByAuthor(author);
    }

    public List<Book> searchByTitle(String title) {
        return BookRepository.getBooksByTitle(title);
    }

    public List<Book> searchByGenre(String genre) {
        return BookRepository.getBooksByGenre(genre);
    }
}
