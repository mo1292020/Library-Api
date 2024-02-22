package com.personal.libraryapi.controller;

import com.personal.libraryapi.dto.UserDto;
import com.personal.libraryapi.entity.UsersEntity;
import com.personal.libraryapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private  UserService userService;


    @GetMapping("/all")
    public List<UsersEntity> findAll(){
        return userService.findAll();
    }

    @GetMapping("/{id}}")
    public Optional<UsersEntity> findById(@PathVariable Long id){
        return userService.findById(id);
    }

    @GetMapping("/add")
    public ResponseEntity<?> addUser(@RequestBody UserDto userDto){
            userService.add(userDto);
        return ResponseEntity.ok(null);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id){
            userService.delete(id);
        return ResponseEntity.ok(null);
    }



}
