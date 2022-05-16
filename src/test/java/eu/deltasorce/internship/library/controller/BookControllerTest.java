package eu.deltasorce.internship.library.controller;

import eu.deltasorce.internship.library.model.book.Author;
import eu.deltasorce.internship.library.model.book.Book;
import eu.deltasorce.internship.library.model.book.OnlineBook;
import eu.deltasorce.internship.library.model.book.PaperBook;
import eu.deltasorce.internship.library.repository.AuthorRepository;
import eu.deltasorce.internship.library.repository.BookRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BookControllerTest {

    private final BookController controller = new BookController();

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

    @BeforeEach
    void clearBookRepository() {
        BookRepository.clear();
    }

    @Test
    void searchingWithEmptyAuthorNameShouldFail() {

        //Given
        String name = "";

        //When
        Executable searchingThrowsException = () -> controller.searchByAuthorName(name);

        //Then
        assertThrows(IllegalArgumentException.class, searchingThrowsException);
    }

    @Test
    void searchingWithAuthorNameShouldReturnFoundBooks() {

        //Given
        BookRepository.add(harryPotter);
        BookRepository.add(shining);
        BookRepository.add(hamlet);
        BookRepository.add(theMysteriousAffair);
        String name = "JK Rowling";

        //When
        List<Book> books = controller.searchByAuthorName(name);

        //Then
        assertEquals(1, books.size());
    }

    @Test
    void searchingWithEmptyTitleShouldFail() {

        //Given
        String title = "";

        //When
        Executable searchingThrowsException = () -> controller.searchByTitle(title);

        //Then
        assertThrows(IllegalArgumentException.class, searchingThrowsException);
    }

    @Test
    void searchingWithTitleShouldReturnFoundBooks() {

        //Given
        BookRepository.add(harryPotter);
        BookRepository.add(shining);
        BookRepository.add(hamlet);
        BookRepository.add(theMysteriousAffair);
        String title = "Harry Potter";

        //When
        List<Book> books = controller.searchByTitle(title);

        //Then
        assertEquals(1, books.size());
    }

    @Test
    void searchingWithEmptyGenreShouldFail() {

        //Given
        String genre = "";

        //When
        Executable searchingThrowsException = () -> controller.searchByGenre(genre);

        //Then
        assertThrows(IllegalArgumentException.class, searchingThrowsException);
    }

    @Test
    void searchingWithGenreShouldReturnFoundBooks() {

        //Given
        BookRepository.add(harryPotter);
        BookRepository.add(shining);
        BookRepository.add(hamlet);
        BookRepository.add(theMysteriousAffair);
        assertEquals(4, BookRepository.numberOfBooks());
        String genre = "Adventure";

        //When
        List<Book> books = controller.searchByGenre(genre);

        //Then
        assertEquals(1, books.size());
    }

}