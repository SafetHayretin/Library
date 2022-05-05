package eu.deltasorce.internship.library.repository;

import eu.deltasorce.internship.library.model.book.Author;

import java.util.ArrayList;
import java.util.List;

public final class AuthorRepo {
    private static final List<Author> authors = new ArrayList<>();

    public static void addAuthor(Author author) {
        authors.add(author);
    }

    public static void deleteAuthor(Author author) {
            authors.remove(author);
    }

    public static boolean isAuthorInRepo(Author author) {
        return authors.contains(author);
    }

    public static int getCollectionLength(){
        return authors.size();
    }

    public static void clearAuthorRepo(){
        authors.clear();
    }
}
