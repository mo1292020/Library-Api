package com.personal.bankapidefault.entity;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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
