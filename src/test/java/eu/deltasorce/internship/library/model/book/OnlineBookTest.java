package eu.deltasorce.internship.library.model.book;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class OnlineBookTest {

    String title = "Harry Potter";

    Author author = new Author("JK Rowling", "UK", LocalDate.parse("1974-09-23"));

    String genre = "Adventure";

    String summary = "Adaptation of the first of J.K. Rowling's popular children's novels about Harry Potter, a boy who learns on his eleventh birthday that he is the orphaned son of two powerful wizards and possesses unique magical powers of his own.";

    String isbn = "9781234567897";

    String readLink = "www.librarySystem.com/harryPotter/readNow";

    String downloadLink = "www.librarySystem.com/harryPotter/downloadNow";

    @Test
    void creatingOnlineBookWithEmptyReadLinkShouldFail() {

        //Given
        readLink = null;

        //When
        Executable nameThrowsIllegalArgument = () -> new OnlineBook(title, author, genre, summary, isbn, readLink, downloadLink);

        //Then
        assertThrows(IllegalArgumentException.class, nameThrowsIllegalArgument);
    }

    @Test
    void creatingOnlineBookWithoutProblemsShouldNotFail() {

        //When
        Executable nameThrowsIllegalArgument = () -> new OnlineBook(title, author, genre, summary, isbn, readLink, downloadLink);

        //Then
        assertDoesNotThrow(nameThrowsIllegalArgument);
    }
}