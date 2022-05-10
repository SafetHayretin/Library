package eu.deltasorce.internship.library.service;

import eu.deltasorce.internship.library.model.book.Author;
import eu.deltasorce.internship.library.model.book.Book;
import eu.deltasorce.internship.library.model.book.OnlineBook;
import eu.deltasorce.internship.library.model.book.PaperBook;
import eu.deltasorce.internship.library.repository.BookRepository;

public class BookService {
    AuthorService service = new AuthorService();

    public boolean addOnlineBook(String name, String authorName, String genre, String summary, String readLink) {
        Author author = service.getAuthorFromRepository(authorName);
        Book book = new OnlineBook(name, author, genre, summary, readLink);
        return BookRepository.add(book);
    }

    public boolean addPaperBook(String name, String authorName, String genre, String summary, String isbn, int total) {
        Author author = service.getAuthorFromRepository(authorName);
        Book harryPotter = new PaperBook(name, author, genre, summary, isbn, total, total);
        return BookRepository.add(harryPotter);
    }

    public boolean deleteById(int index) {
        return BookRepository.deleteById(index);
    }

    public boolean deleteByName(String title){
        return BookRepository.deleteByName(title);
    }

    public Book searchByAuthorName(String name) {
        Author author = service.getAuthorFromRepository(name);
        return BookRepository.getBook(author);
    }
}
