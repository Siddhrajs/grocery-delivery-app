package com.siddhraj.supermarket.service.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.siddhraj.supermarket.service.auth.entity.OAuth2Token;

@Repository
public interface OAuth2TokenRepository extends JpaRepository<OAuth2Token, Long> {

    OAuth2Token findByClientId(String clientId);

    void deleteByClientId(String clientId);
}
