package com.personal.bankapidefault.service.impl;

import com.personal.bankapidefault.dto.BookDto;
import com.personal.bankapidefault.entity.BookEntity;
import com.personal.bankapidefault.mapper.BookMapper;
import com.personal.bankapidefault.repository.BookRepo;
import com.personal.bankapidefault.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepo bookRepo;
    private final BookMapper bookMapper;

    @Override
    public List<BookDto> findAll() {
        List<BookEntity> booksEntity = new ArrayList<>();
        List<BookDto> booksDto = new ArrayList<>();
        booksEntity = bookRepo.findAll();
        for(BookEntity bookEntity : booksEntity){
            booksDto.add(bookMapper.toDto(bookEntity));
        }
        return booksDto;
    }

    @Override
    public Optional<BookEntity> findById(Long id) {
        return bookRepo.findById(id);
    }

    @Override
    public void save(BookDto bookDto) {
        bookRepo.save(bookMapper.toEntity(bookDto));
    }
}
