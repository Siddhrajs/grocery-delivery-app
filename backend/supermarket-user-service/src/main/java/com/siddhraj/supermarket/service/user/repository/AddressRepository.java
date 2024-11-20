package com.siddhraj.supermarket.service.user.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.siddhraj.supermarket.service.user.entity.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

    List<Address> findByUserId(Long userId);

    Address findByUserIdAndIsDefaultTrue(Long userId);
}
