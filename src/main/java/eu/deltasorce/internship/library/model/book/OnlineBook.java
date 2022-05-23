package eu.deltasorce.internship.library.model.book;

import lombok.Getter;

@Getter
public class OnlineBook extends Book {

    private String readLink;

    private String downloadLink;

    /**
     * Creating book with parameters. Every parameter can be empty except download link.
     * We can create books without download link. When it doesn't have download link
     * we set it to null.
     */
    public OnlineBook(String title, Author author, String genre, String summary, String isbn, String readLink, String downloadLink) {
        super(title, author, genre, summary, isbn);
        setReadLink(readLink);
        setDownloadLink(downloadLink);
    }

    public void setReadLink(String readLink) {
        if (readLink == null || readLink.isBlank()) {
            throw new IllegalArgumentException("Link to the book can't be empty!");
        }
        this.readLink = readLink;
    }

    public void setDownloadLink(String downloadLink) {
        this.downloadLink = downloadLink;
    }
}
