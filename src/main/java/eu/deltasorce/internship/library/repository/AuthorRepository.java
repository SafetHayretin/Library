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
        Author author = authors.get(id);
        return authors.remove(author);
    }

    public static Author findByName(String name) {
        for (Author author : authors) {
            if (name.equals(author.getFullName())) {
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
