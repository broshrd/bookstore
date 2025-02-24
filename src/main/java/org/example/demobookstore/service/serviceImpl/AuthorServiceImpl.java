package org.example.demobookstore.service.serviceImpl;

import org.example.demobookstore.AuthorService;
import org.example.demobookstore.model.Author;
import org.example.demobookstore.model.Dto.request.AuthorRequest;
import org.example.demobookstore.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;
    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }


    @Override
    public List<Author> findallAuthors() {
        return authorRepository.findallAuthors();
    }

    @Override
    public Author findAuthorByID(int id) {
        return authorRepository.findAuthorByID(id);
    }

    @Override
    public Author updateAuthorByID(int id, AuthorRequest authorRequest) {
        return authorRepository.updateAuthorByID(id,authorRequest);
    }

    @Override
    public String deleteAuthor(int id) {

        boolean delete = authorRepository.deleteAuthor(id);
       if(delete){
           return "Author deleted successfully";
       }
        return null;
    }

    @Override
    public Author createAuthor(AuthorRequest authorRequest) {
        return authorRepository.createAuthor(authorRequest);
    }
}
