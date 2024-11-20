package com.siddhraj.supermarket.service.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siddhraj.supermarket.service.user.entity.User;
import com.siddhraj.supermarket.service.user.model.UserModel;
import com.siddhraj.supermarket.service.user.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User saveUser(UserModel userModel) {
        User user = User.builder().firstName(userModel.getFirstName()).lastName(userModel.getLastName()).email(userModel.getEmail()).phoneNumber(userModel.getPhoneNumber()).dateOfBirth(userModel.getDateOfBirth()).profilePictureUrl(userModel.getProfilePictureUrl()).build();

        return userRepository.save(user);
    }

    public User updateUser(Long userId, UserModel userModel) {
        User user = User.builder().firstName(userModel.getFirstName()).lastName(userModel.getLastName()).email(userModel.getEmail()).phoneNumber(userModel.getPhoneNumber()).dateOfBirth(userModel.getDateOfBirth()).profilePictureUrl(userModel.getProfilePictureUrl()).build();
        user.setId(userId);
        return userRepository.save(user);
    }

    public User getUserById(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }

    public void deleteByUserId(Long userId) {
        userRepository.deleteById(userId);
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email).orElse(null);
    }

    public User findByPhoneNumber(String phoneNumber) {
        return userRepository.findByPhoneNumber(phoneNumber).orElse(null);
    }

    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    public boolean existsByPhoneNumber(String phoneNumber) {
        return userRepository.existsByPhoneNumber(phoneNumber);
    }

}
