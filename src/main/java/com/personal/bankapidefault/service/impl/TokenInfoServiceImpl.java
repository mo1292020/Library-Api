package com.personal.bankapidefault.service.impl;

import com.personal.bankapidefault.dto.TokenInfoDto;
import com.personal.bankapidefault.entity.TokenInfoEntity;
import com.personal.bankapidefault.mapper.TokenInfoMapper;
import com.personal.bankapidefault.repository.TokenInfoRepo;
import com.personal.bankapidefault.service.TokenInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TokenInfoServiceImpl implements TokenInfoService {

    private final TokenInfoRepo tokenInfoRepo;
    @Autowired
    private final TokenInfoMapper tokenInfoMapper;


    @Override
    public Optional<TokenInfoEntity> findById(Long id) {
        return tokenInfoRepo.findById(id);
    }

    @Override
    public Optional<TokenInfoEntity> findByRefreshToken(String refreshToken) {
        return tokenInfoRepo.findByRefreshToken(refreshToken);
    }

    @Override
    public TokenInfoEntity save(TokenInfoDto tokenInfoDto) {
        return tokenInfoRepo.save(tokenInfoMapper.toEntity(tokenInfoDto));
    }

    @Override
    public void deleteById(Long id) {
         tokenInfoRepo.deleteById(id);
    }
}
