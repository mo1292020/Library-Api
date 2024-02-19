package com.personal.bankapidefault.service.impl;

import com.personal.bankapidefault.dto.BookDto;
import com.personal.bankapidefault.entity.BookEntity;
import com.personal.bankapidefault.entity.UsersEntity;
import com.personal.bankapidefault.mapper.BookMapper;
import com.personal.bankapidefault.repository.BookRepo;
import com.personal.bankapidefault.repository.UserRepo;
import com.personal.bankapidefault.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepo bookRepo;
    private final BookMapper bookMapper;
    private final UserRepo userRepo;

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
    public BookDto findById(Long id) {
        return bookMapper.toDto(bookRepo.findById(id).get());
    }

    @Override
    public void save(BookEntity bookEntity) {
        bookRepo.save(bookEntity);
    }

    @Override
    public void delete(Long  id) {
        bookRepo.deleteById(id);
    }

    @Override
    public void buyBook(Long userId, Long bookId) {
        UsersEntity userEntity = userRepo.findById(userId).get();
        BookEntity bookEntity = bookRepo.findById(bookId).get();
        Set<BookEntity> booksentity = new HashSet<>();
        if(userEntity.getBookEntities()!=null){
            userEntity.getBookEntities().add(bookEntity);
            userRepo.save(userEntity);
        }
        else{
            booksentity.add(bookEntity);
            userEntity.setBookEntities(booksentity);
            userRepo.save(userEntity);
        }

    }

}
