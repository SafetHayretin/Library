package eu.deltasorce.internship.library.model.book;

import lombok.Getter;

@Getter
public class OnlineBook extends Book {
    private String readLink;
    private String downloadLink;

    public OnlineBook(String bookTitle, Author author, String genre, String summary, String readLink) {
        super(bookTitle, author, genre, summary);
        setReadLink(readLink);
    }

    public OnlineBook(String bookTitle, Author author, String genre, String summary, String readLink, String downloadLink) {
        this(bookTitle, author, genre, summary, readLink);
        setDownloadLink(downloadLink);
    }

    public void setReadLink(String readLink) {
        if (readLink == null || readLink.isBlank()) {
            throw new IllegalArgumentException("Link to the book can't be empty!");
        }
        this.readLink = readLink;
    }

    public void setDownloadLink(String downloadLink) {
        if (downloadLink == null || downloadLink.isBlank()) {
            throw new IllegalArgumentException("Link to download the book can't be empty!");
        }
        this.downloadLink = downloadLink;
    }
}
