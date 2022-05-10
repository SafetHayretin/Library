package eu.deltasorce.internship.library.model.book;

import lombok.Getter;

@Getter
public abstract class Book {
    private String bookTitle;
    private Author author;
    private String genre;
    private String summary;
    private String isbn;

    public Book(String bookTitle, Author author, String genre, String summary, String isbn) {
        this(bookTitle, author, genre, summary);
        setIsbn(isbn);
    }

    public Book(String bookTitle, Author author, String genre, String summary) {
        setBookTitle(bookTitle);
        setAuthor(author);
        setGenre(genre);
        setSummary(summary);
    }

    public void setBookTitle(String bookTitle) {
        if (bookTitle == null || bookTitle.isBlank()) {
            throw new IllegalArgumentException("Book title can't be empty!");
        }
        this.bookTitle = bookTitle;
    }

    public void setAuthor(Author author) {
        if (author == null) {
            throw new IllegalArgumentException("Author can't be empty!");
        }
        this.author = author;
    }

    public void setGenre(String genre) {
        if (genre == null || genre.isBlank()) {
            throw new IllegalArgumentException("Genre can't be empty!");
        }
        this.genre = genre;
    }

    public void setSummary(String summary) {
        if (summary == null || summary.isBlank()) {
            throw new IllegalArgumentException("Summary can't be empty!");
        }
        this.summary = summary;
    }

    public void setIsbn(String isbn) {
        if (isbn == null || isbn.isBlank()) {
            throw new IllegalArgumentException("Isbn can't be empty!");
        }
        this.isbn = isbn;
    }
}
