package eu.deltasorce.internship.library.author;

import java.util.List;

public class AuthorRepo {
    private List<AuthorModel> authors;

    public void addAuthor(AuthorModel author) {
        authors.add(author);
    }

    public void deleteAuthor(AuthorModel author) {
        authors.remove(author);
    }
}
