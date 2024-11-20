package com.siddhraj.supermarket.service.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siddhraj.supermarket.service.user.entity.User;
import com.siddhraj.supermarket.service.user.entity.UserRole;
import com.siddhraj.supermarket.service.user.model.UserRoleModel;
import com.siddhraj.supermarket.service.user.repository.UserRepository;
import com.siddhraj.supermarket.service.user.repository.UserRoleRepository;

@Service
public class UserRoleService {
    
    @Autowired
    private UserRoleRepository userRoleRepository;

    @Autowired
    private UserRepository userRepository;

    public UserRole getUserRoleByUserId(Long userId) {
        return userRoleRepository.findByUserId(userId);
    }

    public UserRole saveUserRole(UserRoleModel userRoleModel) {
        UserRole userRole = UserRole.builder().roleName(userRoleModel.getRoleName()).user(userRepository.findById(userRoleModel.getUserId()).orElse(null)).createdBy(userRepository.findById(userRoleModel.getCreatedBy()).orElse(null)).updatedBy(userRepository.findById(userRoleModel.getUpdatedBy()).orElse(null)).build();

        User createdBy = userRepository.findById(userRoleModel.getCreatedBy()).orElse(null);

        if (createdBy != null) {
            userRole.setCreatedBy(createdBy);
        }

        User updatedBy = userRepository.findById(userRoleModel.getUpdatedBy()).orElse(null);

        if (updatedBy != null) {
            userRole.setUpdatedBy(updatedBy);
        }

        return userRoleRepository.save(userRole);
    }

    public void deleteUserRole(Long userRoleId) {
        userRoleRepository.deleteById(userRoleId);
    }

    public void updateUserRole(UserRole userRole) {
        userRoleRepository.save(userRole);
    }
}
