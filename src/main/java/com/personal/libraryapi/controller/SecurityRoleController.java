package com.personal.libraryapi.controller;

import com.personal.libraryapi.service.impl.SecurityRoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/roles")
public class SecurityRoleController {

    @Autowired
    private  SecurityRoleServiceImpl securityRoleServiceImpl;
    @GetMapping
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(securityRoleServiceImpl.findAll());
    }

}