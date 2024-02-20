package com.personal.bankapidefault.controller;

import com.personal.bankapidefault.dto.IdRequestDto;
import com.personal.bankapidefault.dto.BookDto;
import com.personal.bankapidefault.mapper.BookMapper;
import com.personal.bankapidefault.security.APPUserDetail;
import com.personal.bankapidefault.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;
    private Authentication authentication;
    private APPUserDetail appUserDetail;

    private final BookMapper bookMapper;


    @GetMapping
    public List<BookDto> findAll(){
        authentication = SecurityContextHolder.getContext().getAuthentication();
        appUserDetail = (APPUserDetail) authentication.getPrincipal();
        List<GrantedAuthority> userRole = appUserDetail.getAuthorities().stream().collect(toList());
        if(!userRole.contains(new SimpleGrantedAuthority("admin"))) {
            return new ArrayList<>();
        }
        return bookService.findAll();
    }

    @GetMapping("/buy")
    public ResponseEntity<?> buyBook(@RequestBody IdRequestDto idRequestDto){
        authentication = SecurityContextHolder.getContext().getAuthentication();
        appUserDetail = (APPUserDetail) authentication.getPrincipal();
        bookService.buyBook(appUserDetail.getId(), idRequestDto.getId());
        return ResponseEntity.ok(null);
    }


    @GetMapping("/add")
    public ResponseEntity<?> addBook(@RequestBody BookDto bookDto){
        bookService.save(bookMapper.toEntity(bookDto));
        return ResponseEntity.ok(null);
    }



}
