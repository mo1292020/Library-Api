package com.personal.libraryapi.mapper;

import com.personal.libraryapi.dto.SecurityRoleDto;
import com.personal.libraryapi.entity.SecurityRoleEntity;


public interface SecurityRoleMapper {
    SecurityRoleDto toDto(final SecurityRoleEntity securityRoleEntity);
    SecurityRoleEntity toEntity(final SecurityRoleDto securityRoleDto);

}
