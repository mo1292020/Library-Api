package com.personal.bankapidefault.mapper;

import com.personal.bankapidefault.dto.UserDto;
import com.personal.bankapidefault.entity.UsersEntity;
import com.personal.bankapidefault.security.APPUserDetail;
import org.mapstruct.Mapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

public interface UserMapper {
    UserDto toDto(final UsersEntity usersEntity);
    UsersEntity toEntity(final UserDto userDto);

    APPUserDetail toAPPUserDetail(final UsersEntity usersEntity);

}
