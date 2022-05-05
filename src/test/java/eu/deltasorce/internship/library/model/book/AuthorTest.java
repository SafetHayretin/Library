package eu.deltasorce.internship.library.model.book;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AuthorTest {

    @Test
    void creatingAuthorWithEmptyNameShouldReturnException() {
        //Given
        String name = "";
        String country = "UK";
        LocalDate birthDate = LocalDate.parse("1974-09-23");

        //When
        Executable nameThrowsIllegalArgument = () -> new Author(name, country, birthDate);

        //Then
        assertThrows(IllegalArgumentException.class, nameThrowsIllegalArgument);
    }

    @Test
    void creatingAuthorWithEmptyCountryShouldReturnException() {
        //Given
        String name = "JK Rowling";
        String country = "";
        LocalDate birthDate = LocalDate.parse("1974-09-23");

        //When
        Executable countryThrowsIllegalArgument = () -> new Author(name, country, birthDate);

        //Then
        assertThrows(IllegalArgumentException.class, countryThrowsIllegalArgument);
    }

    @Test
    void creatingAuthorWithEmptyBirthDateShouldReturnException() {
        //Given
        String name = "JK Rowling";
        String country = "United Kingdom";
        LocalDate birthDate = null;

        //When
        Executable birthDateThrowsIllegalArgument = () -> new Author(name, country, birthDate);

        //Then
        assertThrows(IllegalArgumentException.class, birthDateThrowsIllegalArgument);
    }

    @Test
    void creatingAuthorWithEmptyDeathDateShouldReturnException() {
        //Given
        String name = "JK Rowling";
        String country = "United Kingdom";
        LocalDate birthDate = LocalDate.parse("1974-09-23");
        LocalDate deathDate = null;

        //When
        Executable deathDateThrowsIllegalArgument = () -> new Author(name, country, birthDate, deathDate);

        //Then
        assertThrows(IllegalArgumentException.class, deathDateThrowsIllegalArgument);
    }

    @Test
    void comparingTwoAuthorsShouldReturnTrue() {
        //Given
        Author author = new Author("Pablo Neruda", "Chile", LocalDate.parse("1904-05-12"), LocalDate.parse("1974-09-23"));
        Author author1 = new Author("Pablo Neruda", "Chile", LocalDate.parse("1904-05-12"), LocalDate.parse("1974-09-23"));

        //When
        boolean isAuthorEqual = author.equals(author1);

        //Then
        assertTrue(isAuthorEqual);
    }

    @Test
    void comparingTwoAuthorsHashCodeShouldReturnTrue() {
        //Given
        Author author = new Author("Pablo Neruda", "Chile", LocalDate.parse("1904-05-12"), LocalDate.parse("1974-09-23"));
        Author author1 = new Author("Pablo Neruda", "Chile", LocalDate.parse("1904-05-12"), LocalDate.parse("1974-09-23"));

        //When
        boolean isAuthorsHashEqual = author.hashCode() == author1.hashCode();

        //Then
        assertTrue(isAuthorsHashEqual);
    }
}