package org.example.demobookstore.service.serviceImp;

import org.example.demobookstore.model.Book;
import org.example.demobookstore.repository.BookRepository;
import org.example.demobookstore.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> findAllBooks() {
        return bookRepository.findAllBooks();
    }

    @Override
    public Book findBookByID(int id) {
        return bookRepository.findBookByID(id);
    }


}
