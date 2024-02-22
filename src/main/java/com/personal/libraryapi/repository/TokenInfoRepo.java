package com.personal.libraryapi.repository;

import com.personal.libraryapi.entity.TokenInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TokenInfoRepo extends JpaRepository<TokenInfoEntity, Long> {
    Optional<TokenInfoEntity> findByRefreshToken(String refreshToken);

}
