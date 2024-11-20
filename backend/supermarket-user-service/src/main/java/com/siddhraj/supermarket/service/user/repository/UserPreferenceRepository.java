package com.siddhraj.supermarket.service.user.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.siddhraj.supermarket.service.user.entity.UserPreference;

@Repository
public interface UserPreferenceRepository extends JpaRepository<UserPreference, Long> {

    List<UserPreference> findByUserId(Long userId);

    String findPreferenceValueByUserIdAndPreferenceName(Long userId, String preferenceName);
}
