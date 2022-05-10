package eu.deltasorce.internship.library.service;

import eu.deltasorce.internship.library.model.book.Author;
import eu.deltasorce.internship.library.repository.AuthorRepository;

public class AuthorService {
    public boolean add(Author author){
        return AuthorRepository.add(author);
    }

    public boolean delete(Author author){
        return AuthorRepository.delete(author);
    }

    public boolean deleteById(int index){
        return AuthorRepository.deleteById(index);
    }
}
