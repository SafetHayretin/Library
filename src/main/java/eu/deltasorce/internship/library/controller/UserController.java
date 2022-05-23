package eu.deltasorce.internship.library.controller;

import eu.deltasorce.internship.library.model.book.OnlineBook;
import eu.deltasorce.internship.library.model.book.PaperBook;
import eu.deltasorce.internship.library.model.user.User;
import eu.deltasorce.internship.library.service.UserService;

public class UserController {

    private final BookController bookController = new BookController();

    private final UserService userService = new UserService();

    public boolean updateReadOnlineHistory(OnlineBook book, User user) {
        validate(book, "Book can't be empty.");
        validate(user, "User can't be empty.");
        return userService.updateReadOnlineBooksHistory(book, user);
    }

    public boolean updateDownloadBookHistory(OnlineBook book, User user) {
        validate(book, "Book can't be empty.");
        validate(user, "User can't be empty.");
        return userService.updateDownloadBooksHistory(book, user);
    }

    public boolean updateBorrowedBooksHistory(PaperBook book, User user) {
        validate(book, "Book can't be empty.");
        validate(user, "User can't be empty.");
        return userService.updateBorrowedBooksHistory(book, user);
    }

    public boolean readBookOnline(OnlineBook book, User user) {
        validate(book, "Book can't be empty.");
        validate(user, "User can't be empty.");
        bookController.getReadLinkByIsbn(book.getIsbn());
        return updateReadOnlineHistory(book, user);
    }

    public boolean DownloadBook(OnlineBook book, User user) {
        validate(book, "Book can't be empty.");
        validate(user, "User can't be empty.");
        bookController.getDownloadLinkByIsbn(book.getIsbn());
        return updateDownloadBookHistory(book, user);
    }

    public void validate(Object obj, String message) {
        if (obj == null) {
            throw new IllegalArgumentException(message);
        }
    }
}
