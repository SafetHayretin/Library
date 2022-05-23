package eu.deltasorce.internship.library.repository;

import eu.deltasorce.internship.library.model.user.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    private static final List<User> users = new ArrayList<>();

    public boolean add(User user) {
        return users.add(user);
    }

}
