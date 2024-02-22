package com.personal.libraryapi.service.impl;

import com.personal.libraryapi.entity.TokenInfoEntity;
import com.personal.libraryapi.repository.TokenInfoRepo;
import com.personal.libraryapi.service.TokenInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TokenInfoServiceImpl implements TokenInfoService {

    @Autowired
    private TokenInfoRepo tokenInfoRepo;

    @Override
    public Optional<TokenInfoEntity> findById(Long id) {
        return tokenInfoRepo.findById(id);
    }

    @Override
    public Optional<TokenInfoEntity> findByRefreshToken(String refreshToken) {
        return tokenInfoRepo.findByRefreshToken(refreshToken);
    }

    @Override
    public TokenInfoEntity save(TokenInfoEntity tokenInfoEntity) {
        return tokenInfoRepo.save(tokenInfoEntity);
    }

    @Override
    public void deleteById(Long id) {
         tokenInfoRepo.deleteById(id);
    }
}
