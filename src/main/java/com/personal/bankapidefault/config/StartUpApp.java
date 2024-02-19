package com.personal.bankapidefault.config;


import com.personal.bankapidefault.dto.BookDto;
import com.personal.bankapidefault.dto.SecurityRoleDto;
import com.personal.bankapidefault.dto.UserDto;
import com.personal.bankapidefault.entity.SecurityRoleEntity;
import com.personal.bankapidefault.mapper.UserMapper;
import com.personal.bankapidefault.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
//
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class StartUpApp  implements CommandLineRunner {

    private final UserService userService;
    private final SecurityRoleService securityRoleService;
    private final SecurityRoleDto securityRoleDto;
    private final BookService bookService;
    private final BookDto bookDto;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    private UserDto userDto ;


    public  Timestamp timestamp = new Timestamp(20);

    @Override
    public void run(String... args) throws Exception {

        if(securityRoleService.findAll().isEmpty()){
            securityRoleDto.setId(1L);
            securityRoleDto.setName("admin");
            securityRoleService.save(securityRoleDto);
            securityRoleDto.setId(2L);
            securityRoleDto.setName("user");
            securityRoleService.save(securityRoleDto);
            securityRoleDto.setId(3L);
            securityRoleDto.setName("employee");
            securityRoleService.save(securityRoleDto);
        }



        if(userService.findAll().isEmpty()) {

            Set<SecurityRoleEntity> adminRoles = new HashSet<>();
            adminRoles.add(securityRoleService.findByName("admin"));

            Set<SecurityRoleEntity> userRoles  = new HashSet<>();
            userRoles.add(securityRoleService.findByName("user"));

            Set<SecurityRoleEntity> employeeRole = new HashSet<>();
            employeeRole.add(securityRoleService.findByName("employee"));

                    userDto = UserDto.builder()
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
            userService.save(userDto);
            userDto = UserDto.builder()
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
            userService.save(userDto);
            userDto = UserDto.builder()
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
            userService.save(userDto);
        }

        if(bookService.findAll().isEmpty()){
            bookDto.setId(1L);
            bookDto.setAuthor("Mohamed Albert");
            bookDto.setISBN("978-3-16-148410-0");
            bookDto.setCategory("Science");
            bookDto.setPrice(200.20);
            bookDto.setOwner(userMapper.toEntity(userService.findById(1L).get()));
            bookDto.setTitle("World to science");
            bookDto.setDeploydAt(timestamp);
            bookDto.setPageNumber(240L);
            bookService.save(bookDto);

            bookDto.setId(2L);
            bookDto.setAuthor("Lotfy Albert");
            bookDto.setISBN("978-3-17-148410-1");
            bookDto.setCategory("Physic");
            bookDto.setPrice(210.20);
            bookDto.setOwner(userMapper.toEntity(userService.findById(2L).get()));
            bookDto.setTitle("World to Physic");
            bookDto.setDeploydAt(timestamp);
            bookDto.setPageNumber(262L);
            bookService.save(bookDto);

            bookDto.setId(3L);
            bookDto.setAuthor("Ahmed Albert");
            bookDto.setISBN("978-3-18-148410-2");
            bookDto.setCategory("Mathematics");
            bookDto.setPrice(180.20);
            bookDto.setOwner(userMapper.toEntity(userService.findById(3L).get()));
            bookDto.setTitle("World to Mathematics");
            bookDto.setDeploydAt(timestamp);
            bookDto.setPageNumber(240L);
            bookService.save(bookDto);
            userDto = userService.findById(2L).get();

        }



    }

}
