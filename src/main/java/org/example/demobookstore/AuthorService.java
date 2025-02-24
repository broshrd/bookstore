package org.example.demobookstore;

import org.example.demobookstore.model.Author;
import org.example.demobookstore.model.Dto.request.AuthorRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AuthorService {
    List<Author> findallAuthors();

    Author findAuthorByID(int id);

    Author updateAuthorByID(int id, AuthorRequest authorRequest);

    String deleteAuthor(int id);

    Author createAuthor(AuthorRequest authorRequest);
}
