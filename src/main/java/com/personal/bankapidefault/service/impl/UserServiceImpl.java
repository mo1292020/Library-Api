package com.personal.bankapidefault.service.impl;

import com.personal.bankapidefault.dto.UserDto;
import com.personal.bankapidefault.entity.UsersEntity;
import com.personal.bankapidefault.mapper.UserMapper;
import com.personal.bankapidefault.repository.UserRepo;
import com.personal.bankapidefault.security.APPUserDetail;
import com.personal.bankapidefault.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;
    @Autowired
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

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
    public Optional<UsersEntity> findById(Long id){
        return userRepo.findById(id);
    }

    @Override
    public void save(UserDto userDto){
        userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
        userRepo.save(userMapper.toEntity(userDto));
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
