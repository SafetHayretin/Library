package eu.deltasorce.internship.library.repository;

import eu.deltasorce.internship.library.model.user.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepo {
    private static List<User> users = new ArrayList<>();

    public void addUser(User user) {
        users.add(user);
    }

    public void deleteBook(User user) {
        users.remove(user);
    }
}
