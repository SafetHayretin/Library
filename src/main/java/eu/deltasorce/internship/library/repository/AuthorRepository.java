package eu.deltasorce.internship.library.repository;

import eu.deltasorce.internship.library.model.book.Author;

import java.util.ArrayList;
import java.util.List;

/**
 * Contains all Authors
 * Have ways to add and delete Authors
 * Have way of emptying repository
 */
public final class AuthorRepository {

    private static final List<Author> authors = new ArrayList<>();

    public static boolean add(Author author) {
        return authors.add(author);
    }

    public static boolean delete(Author author) {
        return authors.remove(author);
    }

    public static boolean deleteById(int id) {
        if (id > authors.size()){
            return false;
        }
        Author author = authors.get(id);
        return authors.remove(author);
    }

    public static Author findByName(String name) {
        for (Author author : authors) {
            if (author.getFullName().equals(name)) {
                return author;
            }
        }
        return null;
    }

    public static int numberOfAuthors() {
        return authors.size();
    }

    public static void clear() {
        authors.clear();
    }
}
