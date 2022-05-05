package eu.deltasorce.internship.library.service;

import eu.deltasorce.internship.library.model.book.Author;
import eu.deltasorce.internship.library.repository.AuthorRepo;

import static eu.deltasorce.internship.library.repository.AuthorRepo.isAuthorInRepo;

public class AuthorService {

    public static String addAuthor(Author author){
        if (isAuthorInRepo(author)) {
            return author.getFullName() + " is already in the repo!";
        }
        else {
            AuthorRepo.addAuthor(author);
            return "Author added successfully.";
        }
    }

    public static void deleteAuthor(Author author){
        if (isAuthorInRepo(author)) {
            AuthorRepo.deleteAuthor(author);
        } else System.out.println(author.getFullName() + " is not in the repository!");
    }
}
