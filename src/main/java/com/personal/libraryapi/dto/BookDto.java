package com.personal.libraryapi.dto;

import com.personal.libraryapi.entity.UsersEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Component
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {

    private Long id;
    private String title;
    private String author;
    private String category;
    private String ISBN;
    private Long pageNumber;
    private Double price;
    private Timestamp deploydAt;
    private UsersEntity owner;

}
