package com.personal.libraryapi.repository;

import com.personal.libraryapi.entity.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<UsersEntity,Integer> {

    Optional<UsersEntity> findById(Long id);
    Optional<UsersEntity> findByUserName(String username);

}
