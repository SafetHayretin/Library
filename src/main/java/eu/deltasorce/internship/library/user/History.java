package eu.deltasorce.internship.library.user;

import eu.deltasorce.internship.library.book.OnlineBook;
import eu.deltasorce.internship.library.book.PaperBook;

import java.util.List;

public class History {
    private List<PaperBook> borrowedBooks;
    private List<OnlineBook> readBooks;
    private List<OnlineBook> downloadedBooks;

    public void addBorrowedBook(PaperBook book) {
        borrowedBooks.add(book);
    }

    public void addReadBook(OnlineBook book) {
        readBooks.add(book);
    }

    public void addDownloadedBook(OnlineBook book) {
        downloadedBooks.add(book);
    }
}
