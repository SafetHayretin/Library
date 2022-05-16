package eu.deltasorce.internship.library.controller;

import eu.deltasorce.internship.library.model.book.Author;
import eu.deltasorce.internship.library.repository.AuthorRepository;
import eu.deltasorce.internship.library.service.AuthorService;

public class AuthorController {

    private final AuthorService service = new AuthorService();

    public boolean add(Author author) {
        if (author == null) {
            throw new IllegalArgumentException("Author was not given");
        }
        return service.add(author);
    }

    public boolean delete(Author author) {
        if (author == null) {
            throw new IllegalArgumentException("Author was not given");
        }
        return service.delete(author);
    }

    public boolean deleteById(int id) {
        if (id < 0 ) {
            throw new IllegalArgumentException("ID cant be negative");
        }
        return service.deleteById(id);
    }
}
