package com.personal.bankapidefault.config;


import com.personal.bankapidefault.dto.SecurityRoleDto;
import com.personal.bankapidefault.dto.UserDto;
import com.personal.bankapidefault.entity.SecurityRoleEntity;
import com.personal.bankapidefault.mapper.SecurityRoleMapper;
import com.personal.bankapidefault.repository.TokenInfoRepo;
import com.personal.bankapidefault.security.JwtTokenUtils;
import com.personal.bankapidefault.service.AuthService;
import com.personal.bankapidefault.service.TokenInfoService;
import com.personal.bankapidefault.service.impl.SecurityRoleServiceImpl;
import com.personal.bankapidefault.service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
//
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class StartUpApp  implements CommandLineRunner {

    private final UserServiceImpl userServiceImpl;
    private final SecurityRoleServiceImpl securityRoleServiceImpl;
    private final SecurityRoleDto securityRoleDto;
    UserDto userDto ;


    public  Timestamp timestamp = new Timestamp(20);

    @Override
    public void run(String... args) throws Exception {

        if(securityRoleServiceImpl.findAll().isEmpty()){
            securityRoleDto.setName("admin");
            securityRoleServiceImpl.save(securityRoleDto);
            securityRoleDto.setName("user");
            securityRoleServiceImpl.save(securityRoleDto);
            securityRoleDto.setName("employee");
            securityRoleServiceImpl.save(securityRoleDto);
        }

        if(userServiceImpl.findAll().isEmpty()) {

            Set<SecurityRoleEntity> adminRoles = new HashSet<>();
            adminRoles.add(securityRoleServiceImpl.findByName("admin"));

            Set<SecurityRoleEntity> userRoles  = new HashSet<>();
            userRoles.add(securityRoleServiceImpl.findByName("user"));

            Set<SecurityRoleEntity> employeeRole = new HashSet<>();
            employeeRole.add(securityRoleServiceImpl.findByName("employee"));

                    userDto = UserDto.builder()
                    .userName("MO02468")
                    .firstName("Mohamed")
                    .lastName("Ibrahim")
                    .email("Mohamed.Ibrahim.Lotfy.02468@gmail.com")
                    .password("002468")
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
            userServiceImpl.save(userDto);
            userDto = UserDto.builder()
                    .userName("LO02468")
                    .firstName("Lotfy")
                    .lastName("Ibrahim")
                    .email("Mohamed.Ibrahim.Lotfy.02468@gmail.com")
                    .phoneNumber("01027004736")
                    .address("Menofia/Egypt")
                    .password("864200")
                    .status(true)
                    .isEnabled(true)
                    .isAccountNonExpired(true)
                    .isAccountNonLocked(true)
                    .isCredentialsNonExpired(true)
                    .createdAt(timestamp)
                    .securityRoleEntities(userRoles)
                    .build();
            userServiceImpl.save(userDto);
            userDto = UserDto.builder()
                    .userName("AH02468")
                    .firstName("Ahmed")
                    .lastName("Ibrahim")
                    .email("Mohamed.Ibrahim.Lotfy.02468@gmail.com")
                    .phoneNumber("01030787799")
                    .address("Menofia/Egypt")
                    .password("200864")
                    .status(true)
                    .isEnabled(true)
                    .isAccountNonExpired(true)
                    .isAccountNonLocked(true)
                    .isCredentialsNonExpired(true)
                    .createdAt(timestamp)
                    .securityRoleEntities(employeeRole)
                    .build();
            userServiceImpl.save(userDto);
        }

    }

}
