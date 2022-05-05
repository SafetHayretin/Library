package eu.deltasorce.internship.library.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static eu.deltasorce.internship.library.repository.AuthorRepository.clearAuthorRepo;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AuthorControllerTest {

    @BeforeEach
    void emptyAuthorCollection() {
        clearAuthorRepo();
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
        boolean success = controller.commandAdd(name, country, birthDate, deathDate);

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
        boolean success = controller.commandAdd(name, country, birthDate);

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

        controller.commandAdd(name, country, birthDate, deathDate);

        //When
        boolean success = controller.commandDelete(name, country, birthDate, deathDate);

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

        controller.commandAdd(name, country, birthDate);

        //When
        boolean success = controller.commandDelete(name, country, birthDate);

        //Then
        assertTrue(success);
    }
}