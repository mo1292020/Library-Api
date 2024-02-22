package com.personal.libraryapi.service;


import com.personal.libraryapi.dto.AccessTokenDto;
import com.personal.libraryapi.dto.JwtResponseDto;
import com.personal.libraryapi.entity.TokenInfoEntity;

public interface AuthService {

    public JwtResponseDto login(String login, String password);

    public TokenInfoEntity createLoginToken(String userName, Long userId);

    public AccessTokenDto refreshAccessToken(String refreshToken);

    public boolean logout(String refreshToken);

}
