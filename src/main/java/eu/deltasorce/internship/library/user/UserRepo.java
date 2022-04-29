package eu.deltasorce.internship.library.user;

import java.util.List;

public class UserRepo {
    private List<UserModel> users;

    public void addUser(UserModel user) {
        users.add(user);
    }

    public void deleteBook(UserModel user) {
        users.remove(user);
    }
}
