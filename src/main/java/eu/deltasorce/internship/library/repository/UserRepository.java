package eu.deltasorce.internship.library.repository;

import eu.deltasorce.internship.library.model.user.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    private static List<User> users = new ArrayList<>();

    public boolean add(User user) {
       return users.add(user);
    }

    public boolean delete(User user) {
       return users.remove(user);
    }
}
