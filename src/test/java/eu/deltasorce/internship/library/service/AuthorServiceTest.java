package eu.deltasorce.internship.library.service;

import eu.deltasorce.internship.library.model.book.Author;
import org.junit.jupiter.api.Test;

import static eu.deltasorce.internship.library.service.AuthorService.*;
import static org.junit.jupiter.api.Assertions.*;

class AuthorServiceTest {
    @Test
    void authorAlreadyShouldBeInRepo(){
        //Given
        Author pablo = new Author("Pablo Neruda", "Chile", "12.05.1904", "23.09.1973");

        //When
        String success = addAuthor(pablo);
        String fail = addAuthor(pablo);

        //Then
        assertEquals(success, "Author added successfully.");
        assertEquals(fail, pablo.getFullName() + " is already in the repo!");
    }

}