package eu.deltasorce.internship.library.service;

import eu.deltasorce.internship.library.model.book.Author;
import eu.deltasorce.internship.library.model.book.Book;
import eu.deltasorce.internship.library.model.book.OnlineBook;
import eu.deltasorce.internship.library.model.book.PaperBook;
import eu.deltasorce.internship.library.repository.BookRepository;

import java.util.List;

public class BookService {

    private final AuthorService service = new AuthorService();

    /**
     * First gets author from repository searching by name
     * Then creates book without download link
     * If download link is given adds it to book
     * @return true/false if book is added to repository or failed
     */
    public boolean addOnlineBook(OnlineBook book) {
        return BookRepository.add(book);
    }

    /**
     * Adds books to repository
     * @return true/false if book is added to repository or failed
     */
    public boolean addPaperBook(PaperBook book) {
        return BookRepository.add(book);
    }

    public boolean deleteByIsbn(String isbn) {
        return BookRepository.deleteByIsbn(isbn);
    }

    /**
     * Goes through all online books and checks for book with same title
     * @return Link where book can be read
     */
    public String findReadableLinkByIsbn(String isbn) {
        return BookRepository.findReadableLinkByIsbn(isbn);
    }

    /**
     * First gets all online books from repository
     * Goes through all online books and checks for book with same title
     * @return Link where book can be downloaded
     */
    public String findDownloadLinkByIsbn(String isbn) {
        return BookRepository.findDownloadLinkByIsbn(isbn);
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
