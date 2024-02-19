package com.personal.bankapidefault.mapper.impl;

import com.personal.bankapidefault.dto.SecurityRoleDto;
import com.personal.bankapidefault.dto.UserDto;
import com.personal.bankapidefault.entity.SecurityRoleEntity;
import com.personal.bankapidefault.mapper.SecurityRoleMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@RequiredArgsConstructor
public class SecurityRoleMapperImpl implements SecurityRoleMapper {


    @Override
    public SecurityRoleDto toDto(SecurityRoleEntity securityRoleEntity) {
        return  SecurityRoleDto.builder()
                .id(securityRoleEntity.getId())
                .name(securityRoleEntity.getName())
                .build();
    }

    @Override
    public SecurityRoleEntity toEntity(SecurityRoleDto securityRoleDto) {
        return SecurityRoleEntity.builder()
                .id(securityRoleDto.getId())
                .name(securityRoleDto.getName())
                .build();
    }

}
