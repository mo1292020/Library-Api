package com.personal.libraryapi.mapper.impl;

import com.personal.libraryapi.dto.UserDto;
import com.personal.libraryapi.entity.UsersEntity;
import com.personal.libraryapi.mapper.UserMapper;
import com.personal.libraryapi.security.APPUserDetail;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDto toDto(UsersEntity usersEntity) {
            return  UserDto.builder()
                    .id(usersEntity.getId())
                    .userName(usersEntity.getUserName())
                    .email(usersEntity.getEmail())
                    .address(usersEntity.getAddress())
                    .createdAt(usersEntity.getCreatedAt())
                    .firstName(usersEntity.getFirstName())
                    .lastName(usersEntity.getLastName())
                    .password(usersEntity.getPassword())
                    .phoneNumber(usersEntity.getPhoneNumber())
                    .status(usersEntity.getStatus())
                    .isCredentialsNonExpired(usersEntity.isAccountNonExpired())
                    .isAccountNonExpired(usersEntity.isAccountNonExpired())
                    .isEnabled(usersEntity.isEnabled())
                    .isAccountNonLocked(usersEntity.isAccountNonLocked())
                    .securityRoleEntities(usersEntity.getSecurityRoleEntities())
                    .purchasedBooks(usersEntity.getBookEntities())
                    .build();
    }

    @Override
    public UsersEntity toEntity(UserDto userDto) {
            return UsersEntity.builder()
                    .id(userDto.getId())
                    .userName(userDto.getUserName())
                    .email(userDto.getEmail())
                    .address(userDto.getAddress())
                    .createdAt(userDto.getCreatedAt())
                    .firstName(userDto.getFirstName())
                    .lastName(userDto.getLastName())
                    .password(userDto.getPassword())
                    .phoneNumber(userDto.getPhoneNumber())
                    .status(userDto.getStatus())
                    .isCredentialsNonExpired(userDto.isAccountNonExpired())
                    .isAccountNonExpired(userDto.isAccountNonExpired())
                    .isEnabled(userDto.isEnabled())
                    .isAccountNonLocked(userDto.isAccountNonLocked())
                    .securityRoleEntities(userDto.getSecurityRoleEntities())
                    .bookEntities(userDto.getPurchasedBooks())
                    .build();
    }

    @Override
    public APPUserDetail toAPPUserDetail(UsersEntity usersEntity) {
        return new APPUserDetail(usersEntity);
    }

    public List<GrantedAuthority> grantedAuthorities(UsersEntity usersEntity){
        List<GrantedAuthority> authorities = new ArrayList<>();
        if(!usersEntity.getSecurityRoleEntities().isEmpty()){
            usersEntity.getSecurityRoleEntities().forEach(securityRoleEntity -> {
                authorities.add(new SimpleGrantedAuthority(securityRoleEntity.getName()));
            });
        }
        authorities.add(new SimpleGrantedAuthority("admin"));
        return authorities;
    }

}
