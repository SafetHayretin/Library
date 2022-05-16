package eu.deltasorce.internship.library.model.book;

import eu.deltasorce.internship.library.model.book.Author;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AuthorTest {

    @Test
    void creatingAuthorWithEmptyNameShouldFail() {

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
    void creatingAuthorWithEmptyCountryShouldFail() {

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
    void creatingAuthorWithEmptyBirthDateShouldFail() {

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
    void creatingAuthorWithEmptyDeathDateShouldFail() {

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
    void creatingAuthorWithDeathDateGreaterThanBirthDateShouldFail() {

        //Given
        String name = "JK Rowling";
        String country = "United Kingdom";
        LocalDate birthDate = LocalDate.parse("1974-09-23");
        LocalDate deathDate = LocalDate.parse("1935-08-24");

        //When
        Executable deathDateThrowsException = () -> new Author(name, country, birthDate, deathDate);

        //Then
        assertThrows(IllegalArgumentException.class, deathDateThrowsException);
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