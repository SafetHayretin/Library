package eu.deltasorce.internship.library.model.user;

import eu.deltasorce.internship.library.model.book.OnlineBook;
import eu.deltasorce.internship.library.model.book.PaperBook;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class User {

    private LoginData login;

    private String name;

    private int age;

    private Sex sex;

    private String address;

    private String email;

    private final List<PaperBook> borrowedBooksHistory = new ArrayList<>();

    private final List<PaperBook> borrowedBooks = new ArrayList<>();

    private final List<OnlineBook> readBooks = new ArrayList<>();

    private final List<OnlineBook> downloadedBooks = new ArrayList<>();

    public User(LoginData login, String name, int age, Sex sex, String address, String email) {
        setLogin(login);
        setName(name);
        setAge(age);
        setSex(sex);
        setAddress(address);
        setEmail(email);
    }

    public boolean updateBorrowedBooks(PaperBook book) {
        return borrowedBooks.add(book);
    }

    public boolean updateReadBookHistory(OnlineBook book) {
        return readBooks.add(book);
    }

    public boolean updateDownloadHistory(OnlineBook book) {
        return downloadedBooks.add(book);
    }

    public boolean updateBorrowedHistory(PaperBook book) {
        return borrowedBooksHistory.add(book);
    }

    public void setLogin(LoginData login) {
        if (login == null) {
            throw new IllegalArgumentException("Login can't be null!");
        }
        this.login = login;
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name can't be empty!");
        }
        this.name = name;
    }

    public void setAge(int age) {
        if (age <= 0) {
            throw new IllegalArgumentException("Age can't be negative!");
        }
        this.age = age;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public void setAddress(String address) {
        if (address == null || address.isBlank()) {
            throw new IllegalArgumentException("Address can't be empty!");
        }
        this.address = address;
    }

    public void setEmail(String email) {
        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("Email can't be empty!");
        }
        this.email = email;
    }

    public LoginData getLogin() {
        return login;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return age == user.age && login.equals(user.login) && name.equals(user.name) &&
                sex == user.sex && address.equals(user.address) && email.equals(user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, name, age, sex, address, email);
    }
}
