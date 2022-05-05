package eu.deltasorce.internship.library.model.book;

public abstract class Book {
    private String bookTitle;
    private Author author;
    private String genre;
    private String summary;
    private int isbn;

    public Book(String bookTitle, Author author, String genre, String summary, int isbn) {
        setBookTitle(bookTitle);
        setAuthor(author);
        setGenre(genre);
        setSummary(summary);
        this.isbn = isbn;
    }

    public Book(String bookTitle, Author author, String genre, String summary) {
        setBookTitle(bookTitle);
        setAuthor(author);
        setGenre(genre);
        setSummary(summary);
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

}
