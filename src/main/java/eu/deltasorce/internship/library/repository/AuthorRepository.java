package eu.deltasorce.internship.library.repository;

import eu.deltasorce.internship.library.model.book.Author;

import java.util.HashSet;
import java.util.Set;

/**
 * Repository where all authors are stored
 */
public final class AuthorRepository {

    private static final Set<Author> authors = new HashSet<>();

    public static boolean add(Author author) {
        return authors.add(author);
    }

    public static boolean delete(Author author) {
        return authors.remove(author);
    }

    public static int getCollectionLength() {
        return authors.size();
    }

    public static void clearAuthorRepo() {
        authors.clear();
    }
}
