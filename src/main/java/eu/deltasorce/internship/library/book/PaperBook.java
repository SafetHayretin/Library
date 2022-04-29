package eu.deltasorce.internship.library.book;

import eu.deltasorce.internship.library.author.AuthorModel;

public class PaperBook extends BookModel {
    private int totalCount;
    private int availableCount;

    public PaperBook(String bookTitle, AuthorModel author, String genre, String summary, int isbn) {
        super(bookTitle, author, genre, summary, isbn);
    }
}
