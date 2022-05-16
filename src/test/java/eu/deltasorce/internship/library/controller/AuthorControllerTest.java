package eu.deltasorce.internship.library.controller;

import eu.deltasorce.internship.library.model.book.Author;
import eu.deltasorce.internship.library.repository.AuthorRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.time.LocalDate;

import static eu.deltasorce.internship.library.repository.AuthorRepository.clear;
import static org.junit.jupiter.api.Assertions.*;

class AuthorControllerTest {

    @BeforeEach
    void emptyAuthorCollection() {
        clear();
    }

    @Test
    void deadAuthorShouldBeAddedCorrectly() {

        //Given
        AuthorController controller = new AuthorController();
        String name = "Pablo Neruda";
        String country = "Chile";
        LocalDate birthDate = LocalDate.parse("1904-05-12");
        LocalDate deathDate = LocalDate.parse("1973-09-23");
        Author author = new Author(name, country, birthDate, deathDate);

        //When
        boolean success = controller.add(author);

        //Then
        assertTrue(success);
    }

    @Test
    void aliveAuthorShouldBeAddedCorrectly() {

        //Given
        AuthorController controller = new AuthorController();
        String name = "JK Rowling";
        String country = "UK";
        LocalDate birthDate = LocalDate.parse("1964-05-12");
        Author author = new Author(name, country, birthDate);

        //When
        boolean success = controller.add(author);

        //Then
        assertTrue(success);
    }

    @Test
    void deadAuthorShouldBeDeletedCorrectly() {

        //Given
        AuthorController controller = new AuthorController();
        String name = "Pablo Neruda";
        String country = "Chile";
        LocalDate birthDate = LocalDate.parse("1904-05-12");
        LocalDate deathDate = LocalDate.parse("1973-09-23");
        Author author = new Author(name, country, birthDate, deathDate);

        controller.add(author);

        //When
        boolean success = controller.delete(author);

        //Then
        assertTrue(success);
    }

    @Test
    void aliveAuthorShouldBeDeletedCorrectly() {

        //Given
        AuthorController controller = new AuthorController();
        String name = "Pablo Neruda";
        String country = "Chile";
        LocalDate birthDate = LocalDate.parse("1904-05-12");
        Author author = new Author(name, country, birthDate);

        assertEquals(0, AuthorRepository.numberOfAuthors());
        controller.add(author);
        assertEquals(1, AuthorRepository.numberOfAuthors());

        //When
        boolean success = controller.delete(author);

        //Then
        assertEquals(0, AuthorRepository.numberOfAuthors());
        assertTrue(success);
    }

    @Test
    void authorShouldBeDeletedById() {

        //Given
        AuthorController controller = new AuthorController();
        String pablo = "Pablo Neruda";
        String chile = "Chile";
        LocalDate birthDate = LocalDate.parse("1904-05-12");

        String rowling = "JK Rowling";
        String unitedKingdom = "United Kingdom";
        LocalDate birthDate1 = LocalDate.parse("1965-05-12");

        Author rowlingAuthor = new Author(rowling, unitedKingdom, birthDate);
        Author pabloAuthor = new Author(pablo, chile, birthDate1);

        assertEquals(0, AuthorRepository.numberOfAuthors());
        controller.add(rowlingAuthor);
        assertEquals(1, AuthorRepository.numberOfAuthors());
        controller.add(pabloAuthor);
        assertEquals(2, AuthorRepository.numberOfAuthors());

        //When
        boolean success = controller.deleteById(1);

        //Then
        assertEquals(1, AuthorRepository.numberOfAuthors());
        assertTrue(success);
    }

    @Test
    void deleteAuthorWithNegativeIdShouldFail() {

        //Given
        AuthorController controller = new AuthorController();
        String pablo = "Pablo Neruda";
        String chile = "Chile";
        LocalDate birthDate = LocalDate.parse("1904-05-12");

        String rowling = "JK Rowling";
        String unitedKingdom = "United Kingdom";
        LocalDate birthDate1 = LocalDate.parse("1965-05-12");

        Author rowlingAuthor = new Author(rowling, unitedKingdom, birthDate);
        Author pabloAuthor = new Author(pablo, chile, birthDate1);

        assertEquals(0, AuthorRepository.numberOfAuthors());
        controller.add(rowlingAuthor);
        assertEquals(1, AuthorRepository.numberOfAuthors());
        controller.add(pabloAuthor);
        assertEquals(2, AuthorRepository.numberOfAuthors());

        //When
        Executable deleteByIdThrowsException = () -> controller.deleteById(-1);

        //Then
        assertThrows(IllegalArgumentException.class, deleteByIdThrowsException);
    }
}