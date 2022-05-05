package eu.deltasorce.internship.library.repository;

import eu.deltasorce.internship.library.model.book.Author;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static eu.deltasorce.internship.library.repository.AuthorRepo.*;
import static org.junit.jupiter.api.Assertions.*;

class AuthorRepoTest {
    @BeforeEach
    void emptyAuthorCollection(){
        clearAuthorRepo();
    }

    @Test
    void authorShouldBeAddedCorrectlyToRepo() {
        //Given
        Author pablo = new Author("Pablo Neruda", "Chile", "12.05.1904", "23.09.1973");

        //When
        addAuthor(pablo);

        //Then
        assertEquals(1, getCollectionLength());
    }

    @Test
    void authorShouldBeDeletedCorrectlyFromRepo() {
        //Given
        Author pablo = new Author("Pablo Neruda", "Chile", "12.05.1904");
        Author rowling = new Author("JK Rowling", "UK", "12.05.1977");

        //When
        addAuthor(pablo);
        addAuthor(rowling);
        deleteAuthor(rowling);

        //Then
        assertEquals(1, getCollectionLength());
    }

    @Test
    void authorShouldBeInRepo() {
        //Given
        Author rowling = new Author("JK Rowling", "UK", "12.05.1977");

        //When
        addAuthor(rowling);

        //Then
        assertTrue(isAuthorInRepo(rowling));
    }
}