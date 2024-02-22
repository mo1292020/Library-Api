package com.personal.libraryapi.service.impl;

import com.personal.libraryapi.dto.UserDto;
import com.personal.libraryapi.entity.UsersEntity;
import com.personal.libraryapi.mapper.UserMapper;
import com.personal.libraryapi.repository.UserRepo;
import com.personal.libraryapi.security.APPUserDetail;
import com.personal.libraryapi.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Log4j2
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private UserMapper userMapper;


    @Override
    public List<UsersEntity> findAll(){
        return userRepo.findAll();
    }

    @Override
    public Optional<UsersEntity> findById(Long id){
        return userRepo.findById(id);
    }

    @Override
    public void save(UsersEntity usersEntity){
        userRepo.save(usersEntity);
    }


    @Override
    public void delete(Long id) {
        Optional<UsersEntity> usersEntity = userRepo.findById(id);
        if(!usersEntity.isPresent()){
            throw new UsernameNotFoundException("This User not found with selected id : " + id);
            }
        usersEntity.get().setStatus(false);
        userRepo.save(usersEntity.get());
    }

    @Override
    public void add(UserDto userDto) {
        userRepo.save(userMapper.toEntity(userDto));
    }

    @Override
    public UserDetails loadUserByUsername(String username){
        Optional<UsersEntity> usersEntity = userRepo.findByUserName(username);
        if(!usersEntity.isPresent()){
            throw new UsernameNotFoundException("This User not found with selected username : " + username);
        }
        return new APPUserDetail(usersEntity.get());
    }
}
