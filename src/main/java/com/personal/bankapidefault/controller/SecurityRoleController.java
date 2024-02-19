package com.personal.bankapidefault.controller;

import com.personal.bankapidefault.security.APPUserDetail;
import com.personal.bankapidefault.service.impl.SecurityRoleServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/api/roles")
@RequiredArgsConstructor
public class SecurityRoleController {

    private final SecurityRoleServiceImpl securityRoleServiceImpl;
    private Authentication authentication;
    private APPUserDetail appUserDetail;

    @GetMapping
    public ResponseEntity<?> findAll(){
        authentication = SecurityContextHolder.getContext().getAuthentication();
        appUserDetail = (APPUserDetail) authentication.getPrincipal();
        List<GrantedAuthority> userRole = appUserDetail.getAuthorities().stream().collect(toList());
        if(!userRole.contains(new SimpleGrantedAuthority("admin"))) {
            return  ResponseEntity.ok(null);
        }
        return ResponseEntity.ok(securityRoleServiceImpl.findAll());
    }

}