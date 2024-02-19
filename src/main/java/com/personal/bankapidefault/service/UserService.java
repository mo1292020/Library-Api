package com.personal.bankapidefault.service;

import com.personal.bankapidefault.dto.UserDto;
import com.personal.bankapidefault.entity.UsersEntity;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Optional;


public interface UserService extends UserDetailsService {

    public List<UserDto> findAll();

    public Optional<UsersEntity> findById(Long id);

    public void save(UserDto userDto);

}
