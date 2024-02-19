package com.personal.bankapidefault.service;

import com.personal.bankapidefault.dto.SecurityRoleDto;
import com.personal.bankapidefault.entity.SecurityRoleEntity;

import java.util.List;


public interface SecurityRoleService {


    public List<SecurityRoleEntity> findAll();

    public SecurityRoleEntity findByName(String name);

    public SecurityRoleEntity save(SecurityRoleDto securityRoleDto);


}
