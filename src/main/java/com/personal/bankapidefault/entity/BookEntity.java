package com.personal.bankapidefault.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID", referencedColumnName = "ID")
    private UsersEntity owner;

    public BookEntity(Long id) {
        super();
        this.id = id;
    }

}
