package com.personal.bankapidefault.controller;

import com.personal.bankapidefault.dto.AccessTokenDto;
import com.personal.bankapidefault.dto.JwtResponseDto;
import com.personal.bankapidefault.dto.LoginRequestDto;
import com.personal.bankapidefault.dto.UserDto;
import com.personal.bankapidefault.entity.UsersEntity;
import com.personal.bankapidefault.service.AuthService;
import com.personal.bankapidefault.service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

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
