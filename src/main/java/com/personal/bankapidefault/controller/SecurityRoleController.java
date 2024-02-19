package com.personal.bankapidefault.controller;

import com.personal.bankapidefault.service.impl.SecurityRoleServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/role")
@RequiredArgsConstructor
public class SecurityRoleController {

    private final SecurityRoleServiceImpl securityRoleServiceImpl;

    @GetMapping
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(securityRoleServiceImpl.findAll());
    }

}