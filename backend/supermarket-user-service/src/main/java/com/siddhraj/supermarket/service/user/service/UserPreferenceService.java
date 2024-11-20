package com.siddhraj.supermarket.service.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siddhraj.supermarket.service.user.entity.UserPreference;
import com.siddhraj.supermarket.service.user.repository.UserPreferenceRepository;

@Service
public class UserPreferenceService {
    
    @Autowired
    private UserPreferenceRepository userPreferenceRepository;

    public List<UserPreference> getUserPreferencesByUserId(Long userId) {
        return userPreferenceRepository.findByUserId(userId);
    }

    public UserPreference saveUserPreference(UserPreference userPreference) {
        return userPreferenceRepository.save(userPreference);
    }

    public void deleteUserPreference(Long userPreferenceId) {
        userPreferenceRepository.deleteById(userPreferenceId);
    }

    public String getPreferenceValueByUserIdAndPreferenceName(Long userId, String preferenceName) {
        return userPreferenceRepository.findPreferenceValueByUserIdAndPreferenceName(userId, preferenceName);
    }
}
