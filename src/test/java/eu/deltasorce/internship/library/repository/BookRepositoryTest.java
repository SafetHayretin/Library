package eu.deltasorce.internship.library.repository;

import eu.deltasorce.internship.library.model.book.Author;
import eu.deltasorce.internship.library.model.book.Book;
import eu.deltasorce.internship.library.model.book.PaperBook;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static eu.deltasorce.internship.library.repository.BookRepository.*;
import static org.junit.jupiter.api.Assertions.*;

class BookRepositoryTest {

    String harrySummary = "Adaptation of the first of J.K. Rowling's popular children's novels about Harry Potter, a boy who learns on his eleventh birthday that he is the orphaned son of two powerful wizards and possesses unique magical powers of his own.";


    @BeforeAll
    void fillAuthorRepository() {
        Author rowling = new Author("JK Rowling", "Britain", LocalDate.parse("1974-09-23"));
        Author agatha = new Author("Agatha Christie", "Britain", LocalDate.parse("1890-09-15"), LocalDate.parse("1890-09-15"));
        Author william = new Author("William Shakespeare", "England", LocalDate.parse("1564-04-26"), LocalDate.parse("1616-04-24"));
        Author stephen = new Author("Stephen Edwin King", "USA", LocalDate.parse("1947-09-21"));
        AuthorRepository.add(rowling);
        AuthorRepository.add(agatha);
        AuthorRepository.add(william);
        AuthorRepository.add(stephen);
    }

    @BeforeEach
    void setUp() {
        Book harryPotter = new PaperBook("Harry Potter", AuthorRepository.getAuthor("JK Rowling") , "Adventure", harrySummary, "9781234567897", 4, 4);
    }

    @AfterEach
    void tearDown() {
        clear();
    }

    @Test
    void shouldWork() {

    }
}