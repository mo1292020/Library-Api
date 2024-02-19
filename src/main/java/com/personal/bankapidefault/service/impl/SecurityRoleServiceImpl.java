package com.personal.bankapidefault.service.impl;

import com.personal.bankapidefault.dto.SecurityRoleDto;
import com.personal.bankapidefault.entity.SecurityRoleEntity;
import com.personal.bankapidefault.mapper.SecurityRoleMapper;
import com.personal.bankapidefault.repository.SecurityRoleRepo;
import com.personal.bankapidefault.service.SecurityRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SecurityRoleServiceImpl implements SecurityRoleService {

    private final SecurityRoleRepo securityRoleRepo;
    private final SecurityRoleMapper securityRoleMapper;

    @Override
    public List<SecurityRoleEntity> findAll(){
        return securityRoleRepo.findAll();
    }

    @Override
    public SecurityRoleEntity findByName(String name){
        return securityRoleRepo.findByName(name);
    }

    @Override
    public SecurityRoleEntity save(SecurityRoleDto securityRoleDto){
        return securityRoleRepo.save(securityRoleMapper.toEntity(securityRoleDto));
    }


}
