package com.personal.bankapidefault.mapper;

import com.personal.bankapidefault.dto.SecurityRoleDto;
import com.personal.bankapidefault.dto.UserDto;
import com.personal.bankapidefault.entity.SecurityRoleEntity;
import com.personal.bankapidefault.entity.UsersEntity;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;


public interface SecurityRoleMapper {
    SecurityRoleDto toDto(final SecurityRoleEntity securityRoleEntity);
    SecurityRoleEntity toEntity(final SecurityRoleDto securityRoleDto);

}
