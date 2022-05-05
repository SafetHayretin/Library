package eu.deltasorce.internship.library.model.user;

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
        if (password.length() < 8){
            throw new IllegalArgumentException("Password can't be less than 8 characters!");
        }
            this.password = password;
    }
}
