package com.personal.bankapidefault.service;


import com.personal.bankapidefault.dto.AccessTokenDto;
import com.personal.bankapidefault.dto.JwtResponseDto;
import com.personal.bankapidefault.entity.TokenInfoEntity;
import com.personal.bankapidefault.security.JwtUnAuthResponse;

public interface AuthService {

    public JwtResponseDto login(String login, String password);

    public TokenInfoEntity createLoginToken(String userName, Long userId);

    public AccessTokenDto refreshAccessToken(String refreshToken);

    public boolean logout(String refreshToken);

}
