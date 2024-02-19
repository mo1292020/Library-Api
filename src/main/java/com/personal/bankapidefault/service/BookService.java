package com.personal.bankapidefault.service;

import com.personal.bankapidefault.dto.BookDto;
import com.personal.bankapidefault.dto.UserDto;
import com.personal.bankapidefault.entity.BookEntity;
import com.personal.bankapidefault.entity.UsersEntity;

import java.util.List;
import java.util.Optional;

public interface BookService {

    public List<BookDto> findAll();

    public Optional<BookEntity> findById(Long id);

    public void save(BookDto bookDto);

}
