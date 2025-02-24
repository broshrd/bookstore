package org.example.demobookstore.repository;

import org.apache.ibatis.annotations.*;
import org.example.demobookstore.model.Author;
import org.example.demobookstore.model.Dto.request.AuthorRequest;


import java.util.List;

@Mapper
public interface AuthorRepository {

    @Select("SELECT * FROM author;")
    @Results(id = "author" , value = {
            @Result( property = "id",column = "author_id")
    })
    List<Author> findallAuthors();

    @Select("SELECT * FROM author where author_id = #{id};")
    @ResultMap("author")
    Author findAuthorByID(int id);

    @Select("UPDATE author SET name = #{authors.name} ,gender= #{authors.gender} WHERE author_id = #{id} RETURNING *" )
    @ResultMap("author")
    Author updateAuthorByID(int id,@Param("authors") AuthorRequest authorRequest);

    @Delete("DELETE FROM author WHERE author_id= #{id};")
    boolean deleteAuthor(int id);


    @Select("INSERT INTO author(name, gender) VALUES (#{author.name},#{author.gender}) RETURNING *")
    @ResultMap("author")
    Author createAuthor(@Param("author") AuthorRequest authorRequest);
}
