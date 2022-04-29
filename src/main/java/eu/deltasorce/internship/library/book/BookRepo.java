package eu.deltasorce.internship.library.book;

import java.util.List;

public class BookRepo {
    private List<BookModel> books;

    public void addBook(BookModel book) {
        books.add(book);
    }

    public void deleteBook(BookModel book) {
        books.remove(book);
    }
}
