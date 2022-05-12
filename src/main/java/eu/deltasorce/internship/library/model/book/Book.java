package eu.deltasorce.internship.library.model.book;

import lombok.Getter;

@Getter
public abstract class Book {

    private String title;

    private Author author;

    private String genre;

    private String summary;

    private String isbn;

    public Book(String title, Author author, String genre, String summary, String isbn) {
        setTitle(title);
        setAuthor(author);
        setGenre(genre);
        setSummary(summary);
        setIsbn(isbn);
    }

    /**
     * Validation for title it can't be null or empty
     */
    public void setTitle(String title) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Book title can't be empty!");
        }
        this.title = title;
    }

    /**
     * Validation for Author it can't be null
     */
    public void setAuthor(Author author) {
        if (author == null) {
            throw new IllegalArgumentException("Author can't be empty!");
        }
        this.author = author;
    }

    /**
     * Validation for genre it can't be null or empty
     */
    public void setGenre(String genre) {
        if (genre == null || genre.isBlank()) {
            throw new IllegalArgumentException("Genre can't be empty!");
        }
        this.genre = genre;
    }

    /**
     * Validation for summary it can't be null or empty
     */
    public void setSummary(String summary) {
        if (summary == null || summary.isBlank()) {
            throw new IllegalArgumentException("Summary can't be empty!");
        }
        this.summary = summary;
    }

    /**
     * Validation for ISBN it can't be null or empty
     */
    public void setIsbn(String isbn) {
        if (isbn == null || isbn.isBlank()) {
            throw new IllegalArgumentException("Isbn can't be empty!");
        }
        this.isbn = isbn;
    }
}
