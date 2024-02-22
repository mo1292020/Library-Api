package com.personal.libraryapi.repository;

import com.personal.libraryapi.entity.SecurityRoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SecurityRoleRepo extends JpaRepository<SecurityRoleEntity,Integer> {
    SecurityRoleEntity findByName(String name);
}
