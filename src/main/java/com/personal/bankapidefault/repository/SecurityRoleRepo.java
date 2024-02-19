package com.personal.bankapidefault.repository;

import com.personal.bankapidefault.entity.SecurityRoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface SecurityRoleRepo extends JpaRepository<SecurityRoleEntity,Integer> {
    SecurityRoleEntity findByName(String name);
}
