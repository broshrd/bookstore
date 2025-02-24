package org.example.demobookstore.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.demobookstore.model.Dto.Category;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book
{
    private int id;
    private String title;
    private LocalDateTime published;
    private Author author;
    List<Category>  categories;
}

