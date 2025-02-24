package org.example.demobookstore.service;

import org.example.demobookstore.model.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService {

    List<Book> findAllBooks();


    Book findBookByID(int id);
}
