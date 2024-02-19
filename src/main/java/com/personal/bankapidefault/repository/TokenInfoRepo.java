package com.personal.bankapidefault.repository;

import com.personal.bankapidefault.entity.TokenInfoEntity;
import com.personal.bankapidefault.entity.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TokenInfoRepo extends JpaRepository<TokenInfoEntity, Long> {
    Optional<TokenInfoEntity> findByRefreshToken(String refreshToken);

}
