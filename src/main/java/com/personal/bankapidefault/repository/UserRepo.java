package com.personal.bankapidefault.repository;

import com.personal.bankapidefault.entity.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<UsersEntity,Integer> {

    Optional<UsersEntity> findById(Long id);
    Optional<UsersEntity> findByUserName(String username);

    Optional <UsersEntity> findByEmail(String email);
}
