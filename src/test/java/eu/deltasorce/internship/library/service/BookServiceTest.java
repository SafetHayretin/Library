package eu.deltasorce.internship.library.service;

import eu.deltasorce.internship.library.model.book.Author;
import eu.deltasorce.internship.library.model.book.Book;
import eu.deltasorce.internship.library.model.book.OnlineBook;
import eu.deltasorce.internship.library.model.book.PaperBook;
import eu.deltasorce.internship.library.repository.AuthorRepository;
import eu.deltasorce.internship.library.repository.BookRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static eu.deltasorce.internship.library.repository.BookRepository.clear;
import static org.junit.jupiter.api.Assertions.*;

class BookServiceTest {

    private final BookService service = new BookService();

    private final String summary = "Summary of book. Keeping it like that for the test for now.";

    private final PaperBook harryPotter = new PaperBook("Harry Potter", AuthorRepository.findByName("JK Rowling"), "Adventure", summary, "9781234567897", 4, 4);

    private final PaperBook theMysteriousAffair = new PaperBook("The Mysterious Affair at Styles", AuthorRepository.findByName("Agatha Christie"), "Novel", summary, "978020137962", 3, 3);

    private final OnlineBook hamlet = new OnlineBook("Hamlet", AuthorRepository.findByName("William Shakespeare"), "Drama", summary, "978020131547", "www.library.com/hamlet/read");

    private final OnlineBook shining = new OnlineBook("The Shining", AuthorRepository.findByName("Stephen King"), "Horror", summary, "978020134875", "www.library.com/theShining/read", "www.library.com/theShining/download");

    @BeforeAll
    static void fillAuthorRepository() {
        Author rowling = new Author("JK Rowling", "Britain", LocalDate.parse("1974-09-23"));
        Author agatha = new Author("Agatha Christie", "Britain", LocalDate.parse("1890-09-15"), LocalDate.parse("1890-09-15"));
        Author william = new Author("William Shakespeare", "England", LocalDate.parse("1564-04-26"), LocalDate.parse("1616-04-24"));
        Author stephen = new Author("Stephen King", "USA", LocalDate.parse("1947-09-21"));
        AuthorRepository.add(rowling);
        AuthorRepository.add(agatha);
        AuthorRepository.add(william);
        AuthorRepository.add(stephen);
    }

    @AfterEach
    void tearDown() {
        clear();
    }

    @Test
    void onlineBookShouldBeAddedCorrectly() {

        //Given
        assertEquals(0, BookRepository.numberOfBooks());

        //When
        boolean isBookAdded = service.addOnlineBook(hamlet);

        //Then
        assertEquals(1, BookRepository.numberOfBooks());
        assertTrue(isBookAdded);
    }

    @Test
    void paperBookShouldBeAddedCorrectly() {

        //Given
        assertEquals(0, BookRepository.numberOfBooks());

        //When
        boolean isBookAdded = service.addPaperBook(harryPotter);

        //Then
        assertEquals(1, BookRepository.numberOfBooks());
        assertTrue(isBookAdded);
    }

    @Test
    void bookShouldBeDeletedCorrectly() {

        //Given
        assertEquals(0, BookRepository.numberOfBooks());
        service.addPaperBook(theMysteriousAffair);
        assertEquals(1, BookRepository.numberOfBooks());

        //When
        boolean isDeleted = service.deleteByIsbn("978020137962");

        //Then
        assertEquals(0, BookRepository.numberOfBooks());
        assertTrue(isDeleted);
    }

    @Test
    void readingBookOnlineShouldReturnLinkCorrectly() {

        //Given
        assertEquals(0, BookRepository.numberOfBooks());
        service.addOnlineBook(hamlet);
        assertEquals(1, BookRepository.numberOfBooks());

        //When
        String link = service.readBookOnline("Hamlet");

        //Then
        assertEquals("www.library.com/hamlet/read", link);
    }

    @Test
    void readingBookOnlineShouldReturnNull() {

        //Given
        assertEquals(0, BookRepository.numberOfBooks());
        service.addOnlineBook(shining);
        assertEquals(1, BookRepository.numberOfBooks());

        //When
        String link = service.readBookOnline("Hamlet");

        //Then
        assertNull(link);
    }

    @Test
    void downloadBookShouldReturnLinkCorrectly() {

        //Given
        assertEquals(0, BookRepository.numberOfBooks());
        service.addOnlineBook(shining);
        assertEquals(1, BookRepository.numberOfBooks());

        //When
        String link = service.downloadBook("The Shining");

        //Then
        assertEquals("www.library.com/theShining/download", link);
    }

    @Test
    void downloadBookShouldReturnNull() {

        //Given
        assertEquals(0, BookRepository.numberOfBooks());
        service.addOnlineBook(hamlet);
        assertEquals(1, BookRepository.numberOfBooks());

        //When
        String link = service.downloadBook("The Shining");

        //Then
        assertNull(link);
    }

    @Test
    void searchBookWithAuthorNameShouldReturnAllBooks() {

        //Given
        assertEquals(0, BookRepository.numberOfBooks());
        service.addOnlineBook(hamlet);
        service.addOnlineBook(shining);
        service.addOnlineBook(hamlet);
        assertEquals(3, BookRepository.numberOfBooks());

        //When
        List<Book> books = service.searchByAuthorName("William Shakespeare");

        //Then
        assertEquals(2, books.size());
    }

    @Test
    void searchBookWithAuthorNameShouldReturnZeroBooks() {

        //Given
        assertEquals(0, BookRepository.numberOfBooks());
        service.addOnlineBook(hamlet);
        service.addOnlineBook(shining);
        service.addOnlineBook(hamlet);
        assertEquals(3, BookRepository.numberOfBooks());

        //When
        List<Book> books = service.searchByAuthorName("JK Rowling");

        //Then
        assertEquals(0, books.size());
    }

    @Test
    void searchBookWithTitleShouldReturnTwoBooks() {

        //Given
        assertEquals(0, BookRepository.numberOfBooks());
        service.addOnlineBook(hamlet);
        service.addOnlineBook(shining);
        service.addOnlineBook(hamlet);
        assertEquals(3, BookRepository.numberOfBooks());

        //When
        List<Book> books = service.searchByTitle("Hamlet");

        //Then
        assertEquals(2, books.size());
    }

    @Test
    void searchBookWithTitleShouldReturnZeroBooks() {

        //Given
        assertEquals(0, BookRepository.numberOfBooks());
        service.addOnlineBook(hamlet);
        service.addOnlineBook(shining);
        service.addOnlineBook(hamlet);
        assertEquals(3, BookRepository.numberOfBooks());

        //When
        List<Book> books = service.searchByTitle("Harry Potter");

        //Then
        assertEquals(0, books.size());
    }

    @Test
    void searchBookWithGenreShouldReturnTwoBooks() {

        //Given
        assertEquals(0, BookRepository.numberOfBooks());
        service.addOnlineBook(hamlet);
        service.addOnlineBook(shining);
        service.addOnlineBook(hamlet);
        assertEquals(3, BookRepository.numberOfBooks());

        //When
        List<Book> books = service.searchByGenre("Drama");

        //Then
        assertEquals(2, books.size());
    }

    @Test
    void searchBookWithGenreShouldReturnZeroBooks() {

        //Given
        assertEquals(0, BookRepository.numberOfBooks());
        service.addOnlineBook(hamlet);
        service.addOnlineBook(shining);
        service.addOnlineBook(hamlet);
        assertEquals(3, BookRepository.numberOfBooks());

        //When
        List<Book> books = service.searchByGenre("Adventure");

        //Then
        assertEquals(0, books.size());
    }
}