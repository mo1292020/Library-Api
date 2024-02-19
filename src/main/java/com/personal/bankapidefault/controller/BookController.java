package com.personal.bankapidefault.controller;

import com.personal.bankapidefault.dto.AddBookRequestDto;
import com.personal.bankapidefault.mapper.BookMapper;
import com.personal.bankapidefault.security.APPUserDetail;
import com.personal.bankapidefault.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/book")
@RequiredArgsConstructor
public class BookController {

    private final UserService userService;
    private Authentication authentication;
    private APPUserDetail appUserDetail;

    private final BookMapper bookMapper;

    @GetMapping("/add")
    public ResponseEntity<?> addBook(@RequestBody AddBookRequestDto addBookRequestDto){
        authentication = SecurityContextHolder.getContext().getAuthentication();
        appUserDetail = (APPUserDetail) authentication.getPrincipal();
        userService.addBook(appUserDetail.getId(),addBookRequestDto.getId());
        return ResponseEntity.ok(null);
    }


}
