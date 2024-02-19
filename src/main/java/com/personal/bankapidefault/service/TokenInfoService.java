package com.personal.bankapidefault.service;

import com.personal.bankapidefault.dto.SecurityRoleDto;
import com.personal.bankapidefault.dto.TokenInfoDto;
import com.personal.bankapidefault.entity.SecurityRoleEntity;
import com.personal.bankapidefault.entity.TokenInfoEntity;

import java.util.List;
import java.util.Optional;


public interface TokenInfoService {



    public Optional<TokenInfoEntity> findById(Long id);
    public Optional<TokenInfoEntity> findByRefreshToken(String refreshToken);
    public TokenInfoEntity save(TokenInfoDto tokenInfoDto);
    public void deleteById(Long id);


}
