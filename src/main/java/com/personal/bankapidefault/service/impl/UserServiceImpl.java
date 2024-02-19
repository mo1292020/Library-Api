package com.personal.bankapidefault.service.impl;

import com.personal.bankapidefault.dto.BookDto;
import com.personal.bankapidefault.dto.UserDto;
import com.personal.bankapidefault.entity.BookEntity;
import com.personal.bankapidefault.entity.UsersEntity;
import com.personal.bankapidefault.mapper.BookMapper;
import com.personal.bankapidefault.mapper.UserMapper;
import com.personal.bankapidefault.repository.BookRepo;
import com.personal.bankapidefault.repository.UserRepo;
import com.personal.bankapidefault.security.APPUserDetail;
import com.personal.bankapidefault.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;
    private final BookRepo bookRepo;
    private final PasswordEncoder passwordEncoder;
    @Autowired
    private final UserMapper userMapper;
    @Autowired
    private final BookMapper bookMapper;

    @Override
    public List<UserDto> findAll(){
        List<UsersEntity> usersEntities = new ArrayList<>();
        List<UserDto> userDtos = new ArrayList<>();
        usersEntities = userRepo.findAll();
        for(UsersEntity usersEntity : usersEntities){
            userDtos.add(userMapper.toDto(usersEntity));
        }
        return userDtos;
    }

    @Override
    public Optional<UserDto> findById(Long id){
        return Optional.ofNullable(userMapper.toDto(userRepo.findById(id).get()));
    }

    @Override
    public void save(UserDto userDto){
        userRepo.save(userMapper.toEntity(userDto));
    }


    @Transactional
    @Override
    public void delete(Long id) {
         userRepo.deleteById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UsersEntity> usersEntity = userRepo.findByUserName(username);
        if(!usersEntity.isPresent()){
            throw new UsernameNotFoundException("This User not found with selected username : " + username);
        }
        //return userMapper.toUserDetail(usersEntity.get());
        return new APPUserDetail(usersEntity.get());
    }
}
