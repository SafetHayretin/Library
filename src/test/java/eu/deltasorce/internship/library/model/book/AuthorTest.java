package eu.deltasorce.internship.library.model.book;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class AuthorTest {

    @Test
    void creatingAuthorWithEmptyNameShouldReturnException(){
        //Given
        String name = "";
        String country = "UK";
        String birthDate = "12.1.1977";
        //When
        Executable nameThrowsIllegalArgument = () -> new Author(name, country, birthDate);

        //Then
        assertThrows( IllegalArgumentException.class, nameThrowsIllegalArgument);
    }

    @Test
    void creatingAuthorWithEmptyCountryShouldReturnException(){
        //Given
        String name = "JK Rowling";
        String country = "";
        String birthDate = "12.1.1977";
        //When
        Executable countryThrowsIllegalArgument = () -> new Author(name, country, birthDate);

        //Then
        assertThrows( IllegalArgumentException.class, countryThrowsIllegalArgument);
    }

    @Test
    void creatingAuthorWithEmptyBirthDateShouldReturnException(){
        //Given
        String name = "JK Rowling";
        String country = "United Kingdom";
        String birthDate = "";
        //When
        Executable birthDateThrowsIllegalArgument = () -> new Author(name, country, birthDate);

        //Then
        assertThrows( IllegalArgumentException.class, birthDateThrowsIllegalArgument);
    }

    @Test
    void creatingAuthorWithEmptyDeathDateShouldReturnException(){
        //Given
        String name = "JK Rowling";
        String country = "United Kingdom";
        String birthDate = "12.01.1977";
        String deathDate = "";
        //When
        Executable deathDateThrowsIllegalArgument = () -> new Author(name, country, birthDate, deathDate);

        //Then
        assertThrows( IllegalArgumentException.class, deathDateThrowsIllegalArgument);
    }

    @Test
    void comparingTwoAuthorsShouldReturnTrue(){
        //Given
        Author author = new Author("Pablo Neruda", "Chile", "12.05.1904", "23.09.1973" );
        Author author1 = new Author("Pablo Neruda", "Chile", "12.05.1904", "23.09.1973");

        //When
        boolean isAuthorEqual = author.equals(author1);

        //Then
        assertTrue(isAuthorEqual);
    }

    @Test
    void comparingTwoAuthorsHashCodeShouldReturnTrue(){
        //Given
        Author author = new Author("Pablo Neruda", "Chile", "12.05.1904", "23.09.1973" );
        Author author1 = new Author("Pablo Neruda", "Chile", "12.05.1904", "23.09.1973");

        //When
        boolean isAuthorsHashEqual = author.hashCode() == author1.hashCode();

        //Then
        assertTrue(isAuthorsHashEqual);
    }
}