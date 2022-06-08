package eu.deltasorce.internship.library.repository;

import eu.deltasorce.internship.library.model.book.Author;
import eu.deltasorce.internship.library.model.book.Book;
import eu.deltasorce.internship.library.model.book.OnlineBook;
import eu.deltasorce.internship.library.model.book.PaperBook;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static eu.deltasorce.internship.library.repository.BookRepository.*;
import static org.junit.jupiter.api.Assertions.*;

class BookRepositoryTest {

    private final String summary = "Summary of book. Keeping it like that for the test for now.";

    private final Book harryPotter = new PaperBook("Harry Potter", AuthorRepository.findByName("JK Rowling"), "Adventure", summary, "9781234567897", 4, 4);

    private final Book theMysteriousAffair = new PaperBook("The Mysterious Affair at Styles", AuthorRepository.findByName("Agatha Christie"), "Novel", summary, "978020137962", 3, 3);

    private final Book hamlet = new OnlineBook("Hamlet", AuthorRepository.findByName("William Shakespeare"), "Drama", summary, "978020131547", "www.library.com/hamlet/read", null);

    private final Book shining = new OnlineBook("The Shining", AuthorRepository.findByName("Stephen King"), "Horror", summary, "978020134875", "www.library.com/theShining/read", "www.library.com/theShining/download");

    @BeforeAll
    static void fillAuthorRepository() {
        Author rowling = new Author("JK Rowling", "Britain", LocalDate.parse("1974-09-23"));
        Author agatha = new Author("Agatha Christie", "Britain", LocalDate.parse("1890-09-15"), LocalDate.parse("1976-01-12"));
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
    void ShouldBeFourAuthorsInAuthorRepository() {
        assertEquals(4, AuthorRepository.numberOfAuthors());
    }

    @Test
    void bookShouldBeAddedCorrectlyToRepository() {

        //Given
        assertEquals(0, numberOfBooks());

        //When
        add(theMysteriousAffair);

        //Then
        assertEquals(1, numberOfBooks());
    }

    @Test
    void bookShouldBeDeletedCorrectlyFromRepository() {

        //Given
        assertEquals(0, numberOfBooks());
        add(harryPotter);
        assertEquals(1, numberOfBooks());
        add(theMysteriousAffair);
        assertEquals(2, numberOfBooks());

        //When
        boolean isDeleted = deleteByIsbn("9781234567897");

        //Then
        assertEquals(1, numberOfBooks());
        assertTrue(isDeleted);
    }

    @Test
    void deletingBookShouldReturnFalse() {

        //Given
        assertEquals(0, numberOfBooks());
        add(harryPotter);
        assertEquals(1, numberOfBooks());
        add(theMysteriousAffair);
        assertEquals(2, numberOfBooks());

        //When
        boolean isDeleted = deleteByIsbn("9781234564444");

        //Then
        assertEquals(2, numberOfBooks());
        assertFalse(isDeleted);
    }

    @Test
    void searchingForBookByAuthorShouldBeFoundCorrectly() {

        //Given
        assertEquals(0, numberOfBooks());
        add(harryPotter);
        assertEquals(1, numberOfBooks());
        add(theMysteriousAffair);
        assertEquals(2, numberOfBooks());
        Author author = AuthorRepository.findByName("JK Rowling");

        //When
        List<Book> foundBooks = getBooksByAuthor(author);

        //Then
        assertEquals(1, foundBooks.size());
        assertEquals(harryPotter, foundBooks.get(0));
    }

    @Test
    void searchingForBookByAuthorShouldWillNotFoundBook() {

        //Given
        assertEquals(0, numberOfBooks());
        add(harryPotter);
        assertEquals(1, numberOfBooks());
        add(theMysteriousAffair);
        assertEquals(2, numberOfBooks());
        Author author = AuthorRepository.findByName("Stephen King");

        //When
        List<Book> foundBooks = getBooksByAuthor(author);

        //Then
        assertEquals(0, foundBooks.size());
    }

    @Test
    void searchingForBookByTitleShouldBeFoundCorrectly() {

        //Given
        assertEquals(0, numberOfBooks());
        add(harryPotter);
        assertEquals(1, numberOfBooks());
        add(theMysteriousAffair);
        assertEquals(2, numberOfBooks());

        //When
        List<Book> foundBooks = getBooksByTitle("Harry Potter");

        //Then
        assertEquals(1, foundBooks.size());
        assertEquals(harryPotter, foundBooks.get(0));
    }

    @Test
    void searchingForBookByTitleShouldNotBeFound() {

        //Given
        assertEquals(0, numberOfBooks());
        add(harryPotter);
        assertEquals(1, numberOfBooks());
        add(theMysteriousAffair);
        assertEquals(2, numberOfBooks());

        //When
        List<Book> foundBooks = getBooksByTitle("IT");

        //Then
        assertEquals(0, foundBooks.size());
    }

    @Test
    void searchingForBookByGenreShouldBeFoundCorrectly() {

        //Given
        assertEquals(0, numberOfBooks());
        add(harryPotter);
        assertEquals(1, numberOfBooks());
        add(theMysteriousAffair);
        assertEquals(2, numberOfBooks());

        //When
        List<Book> foundBooks = getBooksByGenre("Adventure");

        //Then
        assertEquals(1, foundBooks.size());
        assertEquals(harryPotter, foundBooks.get(0));
    }

    @Test
    void searchingForBookByGenreShouldNotBeFound() {

        //Given
        assertEquals(0, numberOfBooks());
        add(harryPotter);
        assertEquals(1, numberOfBooks());
        add(theMysteriousAffair);
        assertEquals(2, numberOfBooks());

        //When
        List<Book> foundBooks = getBooksByGenre("Horror");

        //Then
        assertEquals(0, foundBooks.size());
    }

    @Test
    void numberOfOnlineBooksShouldBeTwo() {

        //Given
        assertEquals(0, numberOfBooks());
        add(shining);
        assertEquals(1, numberOfBooks());
        add(hamlet);
        assertEquals(2, numberOfBooks());

        //When
        List<OnlineBook> onlineBooks = findOnlineBooks();

        //Then
        assertEquals(2, onlineBooks.size());
    }

    @Test
    void numberOfBooksShouldBeThree() {

        //Given
        assertEquals(0, numberOfBooks());
        add(harryPotter);
        assertEquals(1, numberOfBooks());
        add(shining);
        assertEquals(2, numberOfBooks());

        //When
        add(theMysteriousAffair);

        //Then
        assertEquals(3, numberOfBooks());
    }

    @Test
    void bookRepositoryShouldBeEmpty() {

        //Given
        assertEquals(0, numberOfBooks());
        add(harryPotter);
        assertEquals(1, numberOfBooks());
        add(shining);
        assertEquals(2, numberOfBooks());

        //When
        clear();

        //Then
        assertEquals(0, numberOfBooks());
    }

}