package com.personal.libraryapi.service;

import com.personal.libraryapi.entity.SecurityRoleEntity;

import java.util.List;


public interface SecurityRoleService {


    public List<SecurityRoleEntity> findAll();

    public SecurityRoleEntity findByName(String name);

    public SecurityRoleEntity save(SecurityRoleEntity securityRoleEntity);


}
