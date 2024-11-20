package com.siddhraj.supermarket.service.auth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import com.siddhraj.supermarket.service.auth.service.CustomOAuth2AuthorizedClientService;
import com.siddhraj.supermarket.service.auth.service.CustomOAuth2UserService;

@Configuration
public class SecurityConfig {
    @Autowired
    private CustomOAuth2AuthorizedClientService customOAuth2AuthorizedClientService;
    @Autowired
    private CustomOAuth2UserService customOAuth2UserService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                .anyRequest().authenticated()
            )
            .oauth2Login(oauth2Login -> oauth2Login
                .loginPage("/oauth2/authorization/google").defaultSuccessUrl("https://www.googleapis.com/oauth2/v3/userinfo").userInfoEndpoint(userInfoEndpoint -> userInfoEndpoint.userService(customOAuth2UserService))
            ).oauth2Client(oauth2Client -> oauth2Client.authorizedClientService(customOAuth2AuthorizedClientService));
        return http.build();
    }
}
