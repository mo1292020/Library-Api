package com.personal.libraryapi.mapper.impl;

import com.personal.libraryapi.dto.TokenInfoDto;
import com.personal.libraryapi.entity.TokenInfoEntity;
import com.personal.libraryapi.mapper.TokenInfoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TokenInfoMapperImpl implements TokenInfoMapper {
    @Override
    public TokenInfoDto toDto(TokenInfoEntity tokenInfoEntity) {
        return TokenInfoDto.builder()
                .accessToken(tokenInfoEntity.getAccessToken())
                .refreshToken(tokenInfoEntity.getRefreshToken())
                .localIpAddress(tokenInfoEntity.getLocalIpAddress())
                .remoteIpAddress(tokenInfoEntity.getRemoteIpAddress())
                .userAgentText(tokenInfoEntity.getUserAgentText())
                .usersEntity(tokenInfoEntity.getUsersEntity())
                .build();
    }

    @Override
    public TokenInfoEntity toEntity(TokenInfoDto tokenInfoDto) {
        return TokenInfoEntity.builder()
                .accessToken(tokenInfoDto.getAccessToken())
                .refreshToken(tokenInfoDto.getRefreshToken())
                .localIpAddress(tokenInfoDto.getLocalIpAddress())
                .remoteIpAddress(tokenInfoDto.getRemoteIpAddress())
                .userAgentText(tokenInfoDto.getUserAgentText())
                .usersEntity(tokenInfoDto.getUsersEntity())
                .build();
    }
}
