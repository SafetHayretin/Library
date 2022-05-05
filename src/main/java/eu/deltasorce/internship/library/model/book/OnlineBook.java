package eu.deltasorce.internship.library.model.book;

public class OnlineBook extends Book {
    private String readLink;
    private String downloadLink;

    public OnlineBook(String bookTitle, Author author, String genre, String summary, String readLink) {
        super(bookTitle, author, genre, summary);
        this.readLink = readLink;
    }

    public OnlineBook(String bookTitle, Author author, String genre, String summary, String readLink, String downloadLink) {
        super(bookTitle, author, genre, summary);
        this.readLink = readLink;
        this.downloadLink = downloadLink;
    }
}
