package org.example.demobookstore.controller;

import org.example.demobookstore.model.Book;
import org.example.demobookstore.model.Dto.response.APIResponse;
import org.example.demobookstore.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("api/v1/book")
public class bookController {
     private final BookService bookService;

    public bookController(BookService bookService) {
        this.bookService = bookService;
    }
    @GetMapping
    public ResponseEntity<APIResponse<List<Book>>> findAllBooks(){
       APIResponse<List<Book>> response = APIResponse.<List<Book>>builder()
               .message("get all book successful")
               .payload(bookService.findAllBooks())
               .status(HttpStatus.OK)
               .dateTime(LocalDateTime.now())
               .build();
       return ResponseEntity.status(HttpStatus.FOUND).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<APIResponse<Book>> findBookById(@PathVariable int id){
        return ResponseEntity.status(HttpStatus.OK).body(
                new APIResponse<>(
                        "get book by id ",
                        HttpStatus.OK,
                        bookService.findBookByID(id),
                        LocalDateTime.now()
                )
        );
    }

}
