package org.example.demobookstore.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;
import org.example.demobookstore.model.Dto.Category;

import java.util.List;

@Mapper
public interface CategoryRepository {
    @Select("SELECT c.category_id,name FROM category c INNER JOIN book_category bc ON c.category_id = bc.category_id WHERE book_id = #{bookId}")
    @Result(property = "id" ,column = "category_id")
    List<Category> findAllCategory(int bookId);
}
