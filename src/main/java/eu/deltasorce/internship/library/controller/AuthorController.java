package eu.deltasorce.internship.library.controller;

import eu.deltasorce.internship.library.model.book.Author;
import eu.deltasorce.internship.library.service.AuthorService;

import java.time.LocalDate;

/**
 * Class who is responsible for the commands
 */
public class AuthorController {
    private Author author;
    private final AuthorService service = new AuthorService();

    public boolean add(String name, String country, LocalDate birthDate) {
        author = new Author(name, country, birthDate);
        return service.add(author);
    }

    public boolean add(String name, String country, LocalDate birthDate, LocalDate deathDate) {
        author = new Author(name, country, birthDate, deathDate);
        return service.add(author);
    }

    public boolean delete(String name, String country, LocalDate birthDate) {
        author = new Author(name, country, birthDate);
        return service.delete(author);
    }

    public boolean delete(String name, String country, LocalDate birthDate, LocalDate deathDate) {
        author = new Author(name, country, birthDate, deathDate);
        return service.delete(author);
    }

    public boolean deleteById(int index) {
        return service.deleteById(index);
    }
}
