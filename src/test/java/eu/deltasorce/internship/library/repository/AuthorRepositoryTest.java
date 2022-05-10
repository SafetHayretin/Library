package eu.deltasorce.internship.library.repository;

import eu.deltasorce.internship.library.model.book.Author;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static eu.deltasorce.internship.library.repository.AuthorRepository.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class AuthorRepositoryTest {
    @BeforeEach
    void emptyAuthorCollection() {
        clear();
    }

    @Test
    void authorShouldBeAddedCorrectlyToRepo() {
        //Given
        Author pablo = new Author("Pablo Neruda", "Chile", LocalDate.parse("1904-05-12"), LocalDate.parse("1974-09-23"));
        assertEquals(0, numberOfAuthors());
        //When
        add(pablo);

        //Then
        assertEquals(1, numberOfAuthors());
    }

    @Test
    void authorShouldBeDeletedCorrectlyFromRepo() {
        //Given
        Author pablo = new Author("Pablo Neruda", "Chile", LocalDate.parse("1904-05-12"));
        Author rowling = new Author("JK Rowling", "UK", LocalDate.parse("1965-07-31"));

        assertEquals(0, numberOfAuthors());

        add(pablo);
        assertEquals(1, numberOfAuthors());

        add(rowling);
        assertEquals(2, numberOfAuthors());

        //When
        delete(rowling);

        //Then
        assertEquals(1, numberOfAuthors());
    }
}