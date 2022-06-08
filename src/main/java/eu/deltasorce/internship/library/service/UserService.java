package eu.deltasorce.internship.library.service;

import eu.deltasorce.internship.library.model.book.OnlineBook;
import eu.deltasorce.internship.library.model.book.PaperBook;
import eu.deltasorce.internship.library.model.user.User;

public class UserService {

    public boolean updateReadOnlineBooksHistory(OnlineBook book, User user) {
        return user.updateReadBookHistory(book);
    }

    public boolean updateDownloadBooksHistory(OnlineBook book, User user) {
        return user.updateDownloadHistory(book);
    }

    public boolean updateBorrowedBooksHistory(PaperBook book, User user) {
        return user.updateBorrowedHistory(book);
    }
}
