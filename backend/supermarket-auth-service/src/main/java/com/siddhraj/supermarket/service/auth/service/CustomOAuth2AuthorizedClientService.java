package com.siddhraj.supermarket.service.auth.service;

import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.security.oauth2.core.OAuth2RefreshToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.stereotype.Service;

import com.siddhraj.supermarket.service.auth.entity.OAuth2Token;
import com.siddhraj.supermarket.service.auth.repository.OAuth2TokenRepository;

import java.time.LocalDateTime;
import java.time.ZoneId;

@Service
public class CustomOAuth2AuthorizedClientService implements OAuth2AuthorizedClientService {

    @Autowired
    private OAuth2TokenRepository oauth2TokenRepository;

    @Override
    public void saveAuthorizedClient(OAuth2AuthorizedClient authorizedClient, Authentication principal) {
        OAuth2Token oauth2Token = new OAuth2Token();
        oauth2Token.setClientId(authorizedClient.getClientRegistration().getClientId());
        oauth2Token.setAccessToken(authorizedClient.getAccessToken().getTokenValue());
        OAuth2RefreshToken refreshToken = authorizedClient.getRefreshToken();
        oauth2Token.setRefreshToken(refreshToken != null ? refreshToken.getTokenValue() : null);
        
        var expiresAt = authorizedClient.getAccessToken().getExpiresAt();
        oauth2Token.setTokenExpiration(expiresAt != null ?
            LocalDateTime.ofInstant(expiresAt, ZoneId.systemDefault()) : null);

        oauth2TokenRepository.save(oauth2Token);
    }

    @Override
    public OAuth2AuthorizedClient loadAuthorizedClient(String clientRegistrationId, String principalName) {
        OAuth2Token token = oauth2TokenRepository.findByClientId(clientRegistrationId);
        OAuth2AuthorizedClient authorizedClient = new OAuth2AuthorizedClient(
                ClientRegistration.withRegistrationId(clientRegistrationId).build(),
                principalName,
                new OAuth2AccessToken(OAuth2AccessToken.TokenType.BEARER, 
                    token.getAccessToken(), 
                    token.getTokenExpiration() != null ? token.getTokenExpiration().atZone(ZoneId.systemDefault()).toInstant() : null,
                    null),
                token.getRefreshToken() != null ? new OAuth2RefreshToken(token.getRefreshToken(), null) : null
        );
        return authorizedClient;
    }

    @Override
    public void removeAuthorizedClient(String clientRegistrationId, String principalName) {
        oauth2TokenRepository.deleteByClientId(clientRegistrationId);
    }
}
