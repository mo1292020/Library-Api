package com.personal.libraryapi.dto;

import com.personal.libraryapi.entity.BookEntity;
import com.personal.libraryapi.entity.SecurityRoleEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.Set;

@Component
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private Long id;
    private String userName;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phoneNumber;
    private String address;
    private Timestamp createdAt;
    private Boolean status;
    private boolean isEnabled;
    private boolean isCredentialsNonExpired;
    private boolean isAccountNonLocked;
    private boolean isAccountNonExpired;
    private Set<SecurityRoleEntity> securityRoleEntities;
    private Set<BookEntity> purchasedBooks;
}
