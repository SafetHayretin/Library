package eu.deltasorce.internship.library.controller;

import eu.deltasorce.internship.library.model.book.Author;
import eu.deltasorce.internship.library.service.AuthorService;

public class AuthorController {
    private Author author;

    public void addAuthor(String name, String country, String birthDate) {
        author = new Author(name, country, birthDate);
        AuthorService.addAuthor(author);
    }

    public void addAuthor(String name, String country, String birthDate, String deathDate) {
        author = new Author(name, country, birthDate, deathDate);
        AuthorService.addAuthor(author);
    }

    public void deleteAuthor(String name, String country, String birthDate) {
        author = new Author(name, country, birthDate);
        AuthorService.deleteAuthor(author);
    }

    public void deleteAuthor(String name, String country, String birthDate, String deathDate) {
        author = new Author(name, country, birthDate, deathDate);
        AuthorService.deleteAuthor(author);
    }
}
