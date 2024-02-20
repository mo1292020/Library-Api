package com.personal.bankapidefault.controller;

import com.personal.bankapidefault.dto.UserDto;
import com.personal.bankapidefault.mapper.BookMapper;
import com.personal.bankapidefault.security.APPUserDetail;
import com.personal.bankapidefault.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.*;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private Authentication authentication;
    private APPUserDetail appUserDetail;

    private final BookMapper bookMapper;

    @GetMapping()
    public List<UserDto> findAll(){
        authentication = SecurityContextHolder.getContext().getAuthentication();
        appUserDetail = (APPUserDetail) authentication.getPrincipal();
        List<GrantedAuthority> userRole = appUserDetail.getAuthorities().stream().collect(toList());
        if(!userRole.contains(new SimpleGrantedAuthority("admin"))) {
            return new ArrayList<>();
        }
        return userService.findAll();
    }

    @GetMapping("/current")
    public Optional<UserDto> findById(){
        authentication = SecurityContextHolder.getContext().getAuthentication();
        appUserDetail = (APPUserDetail) authentication.getPrincipal();
        return userService.findById(appUserDetail.getId());
    }

}
