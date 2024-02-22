package com.personal.libraryapi.service.impl;

import com.personal.libraryapi.entity.BookEntity;
import com.personal.libraryapi.entity.UsersEntity;
import com.personal.libraryapi.repository.BookRepo;
import com.personal.libraryapi.repository.UserRepo;
import com.personal.libraryapi.security.APPUserDetail;
import com.personal.libraryapi.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepo bookRepo;
    private final UserRepo userRepo;
    private Authentication authentication;
    private APPUserDetail appUserDetail;
    @Override
    public List<BookEntity> findAll() {
        return bookRepo.findAll();
    }

    @Override
    public BookEntity findById(Long id) {
        return bookRepo.findById(id).get();
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
    public void buyBook(Long bookId) {
        authentication = SecurityContextHolder.getContext().getAuthentication();
        appUserDetail = (APPUserDetail) authentication.getPrincipal();
        Optional<UsersEntity> userEntity = userRepo.findById(appUserDetail.getId());
        Optional<BookEntity> bookEntity = bookRepo.findById(bookId);
        if(!userEntity.isPresent()){
            throw new UsernameNotFoundException("This User not found with selected id : " + appUserDetail.getAuthorities());
        }
        if(!bookEntity.isPresent()){
            throw new UsernameNotFoundException("This Book not found with selected id : " + bookId);
        }
        if(userEntity.get().getBookEntities()!=null){
            userEntity.get().getBookEntities().add(bookEntity.get());
            userRepo.save(userEntity.get());
        }
        else{
            Set<BookEntity> booksentity = new HashSet<>();
            booksentity.add(bookEntity.get());
            userEntity.get().setBookEntities(booksentity);
            userRepo.save(userEntity.get());
        }
    }

}
