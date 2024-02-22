package com.personal.libraryapi.service;

import com.personal.libraryapi.entity.TokenInfoEntity;

import java.util.Optional;


public interface TokenInfoService {



    public Optional<TokenInfoEntity> findById(Long id);
    public Optional<TokenInfoEntity> findByRefreshToken(String refreshToken);
    public TokenInfoEntity save(TokenInfoEntity tokenInfoEntity);
    public void deleteById(Long id);


}
