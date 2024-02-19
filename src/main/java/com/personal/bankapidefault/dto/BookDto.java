package com.personal.bankapidefault.dto;

import com.personal.bankapidefault.entity.SecurityRoleEntity;
import com.personal.bankapidefault.entity.UsersEntity;
import lombok.*;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.Set;

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
