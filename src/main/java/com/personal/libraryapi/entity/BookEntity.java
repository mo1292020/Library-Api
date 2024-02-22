package com.personal.libraryapi.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity()
@Builder
@Table(name = "books")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BookEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String title;
    private String author;
    private String category;
    private String ISBN;
    private Long pageNumber;
    private Double price;
    private Timestamp deploydAt;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "USER_ID", referencedColumnName = "ID")
    private com.personal.libraryapi.entity.UsersEntity owner;

    public BookEntity(Long id) {
        super();
        this.id = id;
    }

}
