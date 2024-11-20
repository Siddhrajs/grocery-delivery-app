package com.siddhraj.supermarket.service.auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import com.siddhraj.supermarket.service.auth.entity.User;
import com.siddhraj.supermarket.service.auth.repository.UserRepository;

@Service
public class CustomOAuth2UserService extends DefaultOAuth2UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2User user = super.loadUser(userRequest);
        saveUser(user);
        return user;
    }

    private User saveUser(OAuth2User user) {
        User userEntity = new User();
        userEntity.setName(user.getName());
        userEntity.setEmail(user.getAttribute("email"));
        userEntity.setPicture(user.getAttribute("picture"));
        userEntity.setRole("USER");
        
        return userRepository.save(userEntity);
    }
}
