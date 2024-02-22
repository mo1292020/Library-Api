package com.personal.libraryapi.mapper.impl;

import com.personal.libraryapi.dto.SecurityRoleDto;
import com.personal.libraryapi.entity.SecurityRoleEntity;
import com.personal.libraryapi.mapper.SecurityRoleMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
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
