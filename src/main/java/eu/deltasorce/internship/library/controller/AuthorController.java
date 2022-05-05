package eu.deltasorce.internship.library.controller;

import eu.deltasorce.internship.library.model.book.Author;

import java.time.LocalDate;

import static eu.deltasorce.internship.library.repository.AuthorRepository.add;
import static eu.deltasorce.internship.library.repository.AuthorRepository.delete;

/**
 * Controller which takes commands and runs them
 */
public class AuthorController {
    private Author author;

    public boolean commandAdd(String name, String country, LocalDate birthDate) {
        author = new Author(name, country, birthDate);
        return add(author);
    }

    public boolean commandAdd(String name, String country, LocalDate birthDate, LocalDate deathDate) {
        author = new Author(name, country, birthDate, deathDate);
        return add(author);
    }

    public boolean commandDelete(String name, String country, LocalDate birthDate) {
        author = new Author(name, country, birthDate);
        return delete(author);
    }

    public boolean commandDelete(String name, String country, LocalDate birthDate, LocalDate deathDate) {
        author = new Author(name, country, birthDate, deathDate);
        return delete(author);
    }
}
