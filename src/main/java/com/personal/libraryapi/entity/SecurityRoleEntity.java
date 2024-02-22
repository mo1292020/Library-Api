package com.personal.libraryapi.entity;

import lombok.*;

import javax.persistence.*;

@Entity()
@Table(name = "security_roles")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SecurityRoleEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String name;

}
