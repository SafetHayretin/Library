package eu.deltasorce.internship.library.model.book;

import lombok.Getter;

@Getter
public class PaperBook extends Book {

    private int totalCount;

    private int availableCount;

    public PaperBook(String title, Author author, String genre, String summary, String isbn, int totalCount, int availableCount) {
        super(title, author, genre, summary, isbn);
        this.setTotalCount(totalCount);
        this.setAvailableCount(availableCount);
    }

    public int borrowedCount() {
        return  totalCount - availableCount;
    }

    public void setTotalCount(int totalCount) {
        if (totalCount <= 0) {
            throw new IllegalArgumentException("Total count can't be less than 0!");
        }
        if (totalCount < availableCount) {
            throw new IllegalArgumentException("Total count can't be less than available count!");
        }
        this.totalCount = totalCount;
    }

    public void setAvailableCount(int availableCount) {
        if (availableCount <= 0) {
            throw new IllegalArgumentException("Available count can't be less than 0!");
        }
        if (availableCount > totalCount) {
            throw new IllegalArgumentException("Available count can't be more than total count!");
        }
        this.availableCount = availableCount;
    }

    public void updateCountAfterReturn(){
        availableCount++;
    }

    public void updateCountAfterBorrow(){
        availableCount--;
    }
}
