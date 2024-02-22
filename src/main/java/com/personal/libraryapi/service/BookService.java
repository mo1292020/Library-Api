package com.personal.libraryapi.service;

import com.personal.libraryapi.entity.BookEntity;

import java.util.List;

public interface BookService {

    public List<BookEntity> findAll();

    public BookEntity findById(Long id);

    public void save(BookEntity bookEntity);

    public void delete(Long id);

    public void buyBook(Long bookId);

}
