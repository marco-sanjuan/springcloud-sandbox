package com.marco.oauthservice.security;

import com.marco.oauthservice.users.UsersService;
import com.marco.oauthservice.users.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class TokenExtraInfo implements TokenEnhancer {

    @Autowired
    private UsersService usersService;

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        final User user = usersService.findByUserName(authentication.getName());
        Map<String, Object> info = new HashMap<>();
        info.put("firstName", user.getFirstName());
        info.put("lastName", user.getLastName());
        info.put("email", user.getEmail());
        ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(info);
        return accessToken;
    }
}
