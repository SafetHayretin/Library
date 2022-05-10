package eu.deltasorce.internship.library.repository;

import eu.deltasorce.internship.library.model.book.Author;

import java.util.ArrayList;
import java.util.List;

/**
 * Class who contains List of Author
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

    public static boolean deleteById(int index) {
        Author author = authors.get(index);
        return authors.remove(author);
    }

    public static Author getAuthor(String name) {
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
