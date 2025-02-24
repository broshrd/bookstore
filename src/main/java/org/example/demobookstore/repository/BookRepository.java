package org.example.demobookstore.repository;

import org.apache.ibatis.annotations.*;
import org.example.demobookstore.model.Book;

import java.util.List;

@Mapper
public interface BookRepository {
    @Select("SELECT * FROM book;")
    @Results(id = "books" ,value = {
            @Result(property = "id",column = "book_id"),
            @Result(property = "published",column = "published_date"),
            @Result(property = "author",column ="author_id",one = @One(select ="org.example.demobookstore.repository.AuthorRepository.findAuthorByID")),
            @Result(property = "categories",column = "book_id",many = @Many(select = "org.example.demobookstore.repository.CategoryRepository.findAllCategory"))
    })
    List<Book> findAllBooks();

    @Select("SELECT * FROM book WHERE book_id = #{id};")
    @ResultMap("books")
    Book findBookByID(int id);
}

