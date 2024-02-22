package com.personal.libraryapi.config;


import com.personal.libraryapi.entity.BookEntity;
import com.personal.libraryapi.entity.SecurityRoleEntity;
import com.personal.libraryapi.entity.UsersEntity;
import com.personal.libraryapi.service.BookService;
import com.personal.libraryapi.service.SecurityRoleService;
import com.personal.libraryapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class StartUpApp  implements CommandLineRunner {

    @Autowired
    private  UserService userService;
    @Autowired
    private  SecurityRoleService securityRoleService;
    @Autowired
    private  BookService bookService;
    @Autowired
    private  PasswordEncoder passwordEncoder;
    private  SecurityRoleEntity securityRoleEntity = new SecurityRoleEntity();
    private UsersEntity usersEntity = new UsersEntity();
    private BookEntity bookEntity = new BookEntity();


    public  Timestamp timestamp = new Timestamp(20);

    @Override
    public void run(String... args) throws Exception {

        if(securityRoleService.findAll().isEmpty()){
            securityRoleEntity.setId(1L);
            securityRoleEntity.setName("admin");
            securityRoleService.save(securityRoleEntity);
            securityRoleEntity.setId(2L);
            securityRoleEntity.setName("user");
            securityRoleService.save(securityRoleEntity);
            securityRoleEntity.setId(3L);
            securityRoleEntity.setName("employee");
            securityRoleService.save(securityRoleEntity);
        }



        if(userService.findAll().isEmpty()) {

            Set<SecurityRoleEntity> adminRoles = new HashSet<>();
            adminRoles.add(securityRoleService.findByName("admin"));

            Set<SecurityRoleEntity> userRoles  = new HashSet<>();
            userRoles.add(securityRoleService.findByName("user"));

            Set<SecurityRoleEntity> employeeRole = new HashSet<>();
            employeeRole.add(securityRoleService.findByName("employee"));

                    usersEntity = UsersEntity.builder()
                    .id(1L)
                    .userName("MO02468")
                    .firstName("Mohamed")
                    .lastName("Ibrahim")
                    .email("Mohamed.Ibrahim.Lotfy.02468@gmail.com")
                    .password(passwordEncoder.encode("002468"))
                    .phoneNumber("01289820545")
                    .address("Menofia/Egypt")
                    .status(true)
                    .isEnabled(true)
                    .isAccountNonExpired(true)
                    .isAccountNonLocked(true)
                    .isCredentialsNonExpired(true)
                    .createdAt(timestamp)
                    .securityRoleEntities(adminRoles)
                    .build();
            userService.save(usersEntity);
            usersEntity = UsersEntity.builder()
                    .id(2L)
                    .userName("LO02468")
                    .firstName("Lotfy")
                    .lastName("Ibrahim")
                    .email("Mohamed.Ibrahim.Lotfy.02468@gmail.com")
                    .phoneNumber("01027004736")
                    .address("Menofia/Egypt")
                    .password(passwordEncoder.encode("864200"))
                    .status(true)
                    .isEnabled(true)
                    .isAccountNonExpired(true)
                    .isAccountNonLocked(true)
                    .isCredentialsNonExpired(true)
                    .createdAt(timestamp)
                    .securityRoleEntities(userRoles)
                    .build();
            userService.save(usersEntity);
            usersEntity = UsersEntity.builder()
                    .id(3L)
                    .userName("AH02468")
                    .firstName("Ahmed")
                    .lastName("Ibrahim")
                    .email("Mohamed.Ibrahim.Lotfy.02468@gmail.com")
                    .phoneNumber("01030787799")
                    .address("Menofia/Egypt")
                    .password(passwordEncoder.encode("200864"))
                    .status(true)
                    .isEnabled(true)
                    .isAccountNonExpired(true)
                    .isAccountNonLocked(true)
                    .isCredentialsNonExpired(true)
                    .createdAt(timestamp)
                    .securityRoleEntities(employeeRole)
                    .build();
            userService.save(usersEntity);
        }

        if(bookService.findAll().isEmpty()){
            bookEntity.setId(1L);
            bookEntity.setAuthor("Mohamed Albert");
            bookEntity.setISBN("978-3-16-148410-0");
            bookEntity.setCategory("Science");
            bookEntity.setPrice(200.20);
            bookEntity.setOwner(userService.findById(1L).get());
            bookEntity.setTitle("World to science");
            bookEntity.setDeploydAt(timestamp);
            bookEntity.setPageNumber(240L);
            bookService.save(bookEntity);

            bookEntity.setId(2L);
            bookEntity.setAuthor("Lotfy Albert");
            bookEntity.setISBN("978-3-17-148410-1");
            bookEntity.setCategory("Physic");
            bookEntity.setPrice(210.20);
            bookEntity.setOwner(userService.findById(2L).get());
            bookEntity.setTitle("World to Physic");
            bookEntity.setDeploydAt(timestamp);
            bookEntity.setPageNumber(262L);
            bookService.save(bookEntity);

            bookEntity.setId(3L);
            bookEntity.setAuthor("Ahmed Albert");
            bookEntity.setISBN("978-3-18-148410-2");
            bookEntity.setCategory("Mathematics");
            bookEntity.setPrice(180.20);
            bookEntity.setOwner(userService.findById(3L).get());
            bookEntity.setTitle("World to Mathematics");
            bookEntity.setDeploydAt(timestamp);
            bookEntity.setPageNumber(240L);
            bookService.save(bookEntity);
            usersEntity = userService.findById(2L).get();

        }



    }

}
