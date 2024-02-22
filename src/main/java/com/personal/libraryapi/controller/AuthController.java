package com.personal.libraryapi.controller;

import com.personal.libraryapi.dto.AccessTokenDto;
import com.personal.libraryapi.dto.JwtResponseDto;
import com.personal.libraryapi.dto.LoginRequestDto;
import com.personal.libraryapi.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private  AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<JwtResponseDto> login(@RequestBody LoginRequestDto loginRequestDto){
        JwtResponseDto jwtResponseDto = authService
                .login(loginRequestDto.getUserName(),loginRequestDto.getPassword());
        return ResponseEntity.ok(jwtResponseDto);
    }

    @PostMapping("/refresh-token")
    public ResponseEntity<AccessTokenDto> refreshAccessToken(@RequestHeader("Authorization") String refreshToken) {

        AccessTokenDto accessTokenDto = authService.refreshAccessToken(refreshToken);

        return ResponseEntity.ok(accessTokenDto);
    }


    @PostMapping("/logout")
    public ResponseEntity<?> logout(@RequestHeader("Authorization") String refreshToken) {

        return ResponseEntity.ok(authService.logout(refreshToken));
    }

}
