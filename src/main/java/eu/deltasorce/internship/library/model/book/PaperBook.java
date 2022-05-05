package eu.deltasorce.internship.library.model.book;

public class PaperBook extends Book {
    private int totalCount;
    private int availableCount;

    public PaperBook(String bookTitle, Author author, String genre, String summary, int isbn, int totalCount) {
        super(bookTitle, author, genre, summary, isbn);
        this.setTotalCount(totalCount);
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public void setAvailableCount(int availableCount) {
        this.availableCount = availableCount;
    }
}
