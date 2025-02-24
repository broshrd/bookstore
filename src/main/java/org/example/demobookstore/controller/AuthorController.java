package org.example.demobookstore.controller;

import lombok.Data;
import org.example.demobookstore.AuthorService;
import org.example.demobookstore.model.Author;
import org.example.demobookstore.model.Dto.request.AuthorRequest;
import org.example.demobookstore.model.Dto.response.APIResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("api/v1/author")
public class AuthorController {
   private final AuthorService authorService;


    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }
    @GetMapping
    public ResponseEntity<APIResponse<List<Author>>> findallAuthors() {
        return ResponseEntity.status(HttpStatus.OK).body(
                new APIResponse<>(
                        "get all authors.",
                        HttpStatus.OK,
                        authorService.findallAuthors(),
                        LocalDateTime.now()
                )
        );
    }
    @GetMapping("/{id}")
    public ResponseEntity<APIResponse<Author>> findAuthorById(@PathVariable int id) {
        return ResponseEntity.status(HttpStatus.OK).body(
                new APIResponse<>(
                        "get Author by ID =" + id ,
                        HttpStatus.OK,
                        authorService.findAuthorByID(id),
                        LocalDateTime.now()
                )
        );
    }
    @PutMapping("/{id}")
    public ResponseEntity<APIResponse<Author>> updateAuthor(@PathVariable int id, @RequestBody AuthorRequest authorRequest) {
        return ResponseEntity.status(HttpStatus.OK).body(
                new APIResponse<>(
                        "update author Id="+ id,
                        HttpStatus.FOUND,
                        authorService.updateAuthorByID(id,authorRequest),
                        LocalDateTime.now()
                )
        );
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<APIResponse<String>> deleteAuthor(@PathVariable int id) {
        return ResponseEntity.status(HttpStatus.OK).body(
                new APIResponse<>("Delete successfully",
                        HttpStatus.OK,
                        authorService.deleteAuthor(id),
                        LocalDateTime.now()
                        )
        );
    }
    @PostMapping
    public ResponseEntity<APIResponse<Author>> addAuthor(@RequestBody AuthorRequest authorRequest) {
        return ResponseEntity.status(HttpStatus.OK).body(
                new APIResponse<>(
                        "Insert Author",
                        HttpStatus.CREATED,
                        authorService.createAuthor(authorRequest),
                        LocalDateTime.now()
                )
        );
    }
}
