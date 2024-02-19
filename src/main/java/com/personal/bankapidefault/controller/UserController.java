package com.personal.bankapidefault.controller;

import com.personal.bankapidefault.dto.UserDto;
import com.personal.bankapidefault.entity.UsersEntity;
import com.personal.bankapidefault.security.APPUserDetail;
import com.personal.bankapidefault.service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {

    private final UserServiceImpl userServiceImpl;
    private Authentication authentication;
    private APPUserDetail appUserDetail;

    @GetMapping("/users")
    public List<UserDto> findAll(){
        authentication = SecurityContextHolder.getContext().getAuthentication();
        appUserDetail = (APPUserDetail) authentication.getPrincipal();
        List<GrantedAuthority> userRole = appUserDetail.getAuthorities().stream().collect(toList());
        if(!userRole.contains(new SimpleGrantedAuthority("admin"))) {
            return new ArrayList<>();
        }
        return userServiceImpl.findAll();
    }

    @GetMapping("/user")
    public Optional<UsersEntity> findById(){
        authentication = SecurityContextHolder.getContext().getAuthentication();
        appUserDetail = (APPUserDetail) authentication.getPrincipal();
        return userServiceImpl.findById(appUserDetail.getId());
    }

}
