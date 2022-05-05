package eu.deltasorce.internship.library.controller;

import eu.deltasorce.internship.library.service.UserService;

public class UserController {
    public boolean login(){
        UserService.login();
    }
}
