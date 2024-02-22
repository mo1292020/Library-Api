package com.personal.libraryapi.service;

import com.personal.libraryapi.dto.UserDto;
import com.personal.libraryapi.entity.UsersEntity;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Optional;


public interface UserService extends UserDetailsService {

    public List<UsersEntity> findAll();

    public Optional<UsersEntity> findById(Long id);

    public void save(UsersEntity usersEntity);
    public void delete(Long id);

    public void add(UserDto userDto);



}
