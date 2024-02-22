package com.personal.libraryapi.service.impl;

import com.personal.libraryapi.entity.SecurityRoleEntity;
import com.personal.libraryapi.repository.SecurityRoleRepo;
import com.personal.libraryapi.service.SecurityRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SecurityRoleServiceImpl implements SecurityRoleService {

    @Autowired
    private  SecurityRoleRepo securityRoleRepo;

    @Override
    public List<SecurityRoleEntity> findAll(){
        return securityRoleRepo.findAll();
    }

    @Override
    public SecurityRoleEntity findByName(String name){
        return securityRoleRepo.findByName(name);
    }

    @Override
    public SecurityRoleEntity save(SecurityRoleEntity securityRoleEntity){
        return securityRoleRepo.save(securityRoleEntity);
    }


}
