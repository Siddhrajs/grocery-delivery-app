package com.siddhraj.supermarket.service.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.siddhraj.supermarket.service.user.entity.UserRole;

@Repository 
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {

    UserRole findByUserId(Long userId);
}
