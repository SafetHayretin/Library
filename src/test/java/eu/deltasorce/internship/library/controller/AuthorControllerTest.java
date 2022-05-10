package eu.deltasorce.internship.library.controller;

import eu.deltasorce.internship.library.repository.AuthorRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static eu.deltasorce.internship.library.repository.AuthorRepository.clear;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

        //When
        boolean success = controller.add(name, country, birthDate, deathDate);

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

        //When
        boolean success = controller.add(name, country, birthDate);

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

        controller.add(name, country, birthDate, deathDate);

        //When
        boolean success = controller.delete(name, country, birthDate, deathDate);

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

        controller.add(name, country, birthDate);

        //When
        boolean success = controller.delete(name, country, birthDate);

        //Then
        assertEquals(0, AuthorRepository.numberOfAuthors());
        assertTrue(success);
    }

    @Test
    void authorShouldBeDeletedByIndex() {
        //Given
        AuthorController controller = new AuthorController();
        String pablo = "Pablo Neruda";
        String chile = "Chile";
        LocalDate birthDate = LocalDate.parse("1904-05-12");

        String rowling = "JK Rowling";
        String unitedKingdom = "United Kingdom";
        LocalDate birthDate1 = LocalDate.parse("1965-05-12");

        controller.add(pablo, chile, birthDate);
        controller.add(rowling, unitedKingdom, birthDate1);
        assertEquals(2, AuthorRepository.numberOfAuthors());

        //When
        boolean success = controller.deleteById(1);

        //Then
        assertEquals(1, AuthorRepository.numberOfAuthors());
        assertTrue(success);
    }
}