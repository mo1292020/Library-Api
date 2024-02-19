package com.personal.bankapidefault.service;

import com.personal.bankapidefault.dto.BookDto;
import com.personal.bankapidefault.dto.UserDto;
import com.personal.bankapidefault.entity.BookEntity;
import com.personal.bankapidefault.entity.UsersEntity;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Optional;
import java.util.Set;


public interface UserService extends UserDetailsService {

    public List<UserDto> findAll();

    public Optional<UserDto> findById(Long id);

    public void save(UserDto userDto);
    public void addBook(Long userId, Long bookId);
    public void delete(Long id);


}
