package eu.deltasorce.internship.library.model.user;

import java.util.Objects;

public class LoginData {
    private String username;
    private String password;

    public LoginData(String username, String password) {
        setUsername(username);
        setPassword(password);
    }

    public void setUsername(String username) {
        if (username == null || username.isBlank()) {
            throw new IllegalArgumentException("Name can't be empty!");
        }
        this.username = username;
    }

    public void setPassword(String password) {
        if (password.length() < 8) {
            throw new IllegalArgumentException("Password can't be less than 8 characters!");
        }
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LoginData)) return false;
        LoginData loginData = (LoginData) o;
        return username.equals(loginData.username) && password.equals(loginData.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password);
    }
}
