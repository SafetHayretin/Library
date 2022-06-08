package eu.deltasorce.internship.library.model.book;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class PaperBookTest {

    private String title = "Harry Potter";

    private Author author = new Author("JK Rowling", "UK", LocalDate.parse("1974-09-23"));

    private String genre = "Adventure";

    private String summary = "Adaptation of the first of J.K. Rowling's popular children's novels about Harry Potter, a boy who learns on his eleventh birthday that he is the orphaned son of two powerful wizards and possesses unique magical powers of his own.";

    private String isbn = "9781234567897";

    private int total = 4;

    private int available = 4;

    @Test
    void creatingPaperBookWithEmptyTitleShouldFail() {

        //Given
        title = "";

        //When
        Executable nameThrowsIllegalArgument = () -> new PaperBook(title, author, genre, summary, isbn, total, available);

        //Then
        assertThrows(IllegalArgumentException.class, nameThrowsIllegalArgument);
    }

    @Test
    void creatingPaperBookWithNullAuthorShouldFail() {

        //Given
        author = null;

        //When
        Executable nameThrowsIllegalArgument = () -> new PaperBook(title, author, genre, summary, isbn, total, available);

        //Then
        assertThrows(IllegalArgumentException.class, nameThrowsIllegalArgument);
    }

    @Test
    void creatingPaperBookWithEmptyGenreShouldFail() {

        //Given
        genre = "";

        //When
        Executable nameThrowsIllegalArgument = () -> new PaperBook(title, author, genre, summary, isbn, total, available);

        //Then
        assertThrows(IllegalArgumentException.class, nameThrowsIllegalArgument);
    }

    @Test
    void creatingPaperBookWithEmptySummaryShouldFail() {

        //Given
        summary = "";

        //When
        Executable nameThrowsIllegalArgument = () -> new PaperBook(title, author, genre, summary, isbn, total, available);

        //Then
        assertThrows(IllegalArgumentException.class, nameThrowsIllegalArgument);
    }

    @Test
    void creatingPaperBookWithEmptyIsbnShouldFail() {

        //Given
        isbn = "";

        //When
        Executable nameThrowsIllegalArgument = () -> new PaperBook(title, author, genre, summary, isbn, total, available);

        //Then
        assertThrows(IllegalArgumentException.class, nameThrowsIllegalArgument);
    }

    @Test
    void creatingPaperBookWithTotalCountLessThanAvailableCountShouldFail() {

        //Given
        total = 3;

        //When
        Executable nameThrowsIllegalArgument = () -> new PaperBook(title, author, genre, summary, isbn, total, available);

        //Then
        assertThrows(IllegalArgumentException.class, nameThrowsIllegalArgument);
    }

    @Test
    void creatingPaperBookWithAvailableCountMoreThanTotalCountShouldFail() {

        //Given
        available = 5;

        //When
        Executable nameThrowsIllegalArgument = () -> new PaperBook(title, author, genre, summary, isbn, total, available);

        //Then
        assertThrows(IllegalArgumentException.class, nameThrowsIllegalArgument);
    }

    @Test
    void creatingPaperBookShouldNotFail() {

        //When
        Executable nameThrowsIllegalArgument = () -> new PaperBook(title, author, genre, summary, isbn, total, available);

        //Then
        assertDoesNotThrow(nameThrowsIllegalArgument);
    }

    @Test
    void availableCountShouldBeThreeAfterBorrowing() {

        //Given
        PaperBook harryPotter = new PaperBook(title, author, genre, summary, isbn, total, available);

        //When
        harryPotter.updateCountAfterBorrow();

        //Then
        assertEquals(3, harryPotter.getAvailableCount());
        assertEquals(1, harryPotter.borrowedCount());
    }

    @Test
    void borrowedCountShouldBeThreeAfterBorrowingThreeTimes() {

        //Given
        PaperBook harryPotter = new PaperBook(title, author, genre, summary, isbn, total, available);
        harryPotter.updateCountAfterBorrow();
        harryPotter.updateCountAfterBorrow();

        //When
        harryPotter.updateCountAfterBorrow();

        //Then
        assertEquals(1, harryPotter.getAvailableCount());
        assertEquals(3, harryPotter.borrowedCount());
    }

    @Test
    void borrowedCountShouldBeOneAfterReturningBook() {

        //Given
        PaperBook harryPotter = new PaperBook(title, author, genre, summary, isbn, total, available);
        harryPotter.updateCountAfterBorrow();
        harryPotter.updateCountAfterBorrow();

        //When
        harryPotter.updateCountAfterReturn();

        //Then
        assertEquals(3, harryPotter.getAvailableCount());
        assertEquals(1, harryPotter.borrowedCount());
    }
}