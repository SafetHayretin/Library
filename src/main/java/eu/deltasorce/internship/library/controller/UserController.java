package eu.deltasorce.internship.library.controller;

import eu.deltasorce.internship.library.model.user.LoginData;
import eu.deltasorce.internship.library.service.UserService;

public class UserController {
    UserService userService = new UserService();

    public boolean login(String username, String password){
        LoginData loginData = new LoginData(username, password);
        return userService.login(loginData);
    }
}
