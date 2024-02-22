package com.personal.libraryapi.mapper;

import com.personal.libraryapi.dto.UserDto;
import com.personal.libraryapi.entity.UsersEntity;
import com.personal.libraryapi.security.APPUserDetail;

public interface UserMapper {
    UserDto toDto(final UsersEntity usersEntity);
    UsersEntity toEntity(final UserDto userDto);

    APPUserDetail toAPPUserDetail(final UsersEntity usersEntity);

}
