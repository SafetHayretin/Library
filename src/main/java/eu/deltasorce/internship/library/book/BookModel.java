package eu.deltasorce.internship.library.book;

import eu.deltasorce.internship.library.author.AuthorModel;

public abstract class BookModel {
    private String bookTitle;
    private AuthorModel author;
    private String genre;
    private String summary;
    private final int ISBN;

    public BookModel(String bookTitle, AuthorModel author, String genre, String summary, int isbn) {
        setBookTitle(bookTitle);
        setAuthor(author);
        setGenre(genre);
        setSummary(summary);
        ISBN = isbn;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public void setAuthor(AuthorModel author) {
        this.author = author;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
}
