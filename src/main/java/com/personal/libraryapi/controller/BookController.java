package com.personal.libraryapi.controller;

import com.personal.libraryapi.dto.BookDto;
import com.personal.libraryapi.dto.IdRequestDto;
import com.personal.libraryapi.entity.BookEntity;
import com.personal.libraryapi.mapper.BookMapper;
import com.personal.libraryapi.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookController {

    @Autowired
    private BookService bookService;
    @Autowired
    private final BookMapper bookMapper;


    @GetMapping
    public List<BookEntity> findAll(){
        return bookService.findAll();
    }

    @GetMapping("/buy")
    public ResponseEntity<?> buyBook(@RequestBody IdRequestDto idRequestDto){
        bookService.buyBook(idRequestDto.getId());
        return ResponseEntity.ok(null);
    }


    @GetMapping("/add")
    public ResponseEntity<?> addBook(@RequestBody BookDto bookDto){
        bookService.save(bookMapper.toEntity(bookDto));
        return ResponseEntity.ok(null);
    }



}
