package com.personal.libraryapi.mapper;

import com.personal.libraryapi.dto.TokenInfoDto;
import com.personal.libraryapi.entity.TokenInfoEntity;

public interface TokenInfoMapper {

    TokenInfoDto toDto(final TokenInfoEntity tokenInfoEntity);
    TokenInfoEntity toEntity(final TokenInfoDto tokenInfoDto);

}
