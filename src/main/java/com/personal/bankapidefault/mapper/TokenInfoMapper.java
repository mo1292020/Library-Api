package com.personal.bankapidefault.mapper;

import com.personal.bankapidefault.dto.TokenInfoDto;
import com.personal.bankapidefault.dto.UserDto;
import com.personal.bankapidefault.entity.TokenInfoEntity;
import com.personal.bankapidefault.entity.UsersEntity;
import org.springframework.security.core.userdetails.UserDetails;

public interface TokenInfoMapper {

    TokenInfoDto toDto(final TokenInfoEntity tokenInfoEntity);
    TokenInfoEntity toEntity(final TokenInfoDto tokenInfoDto);

}
