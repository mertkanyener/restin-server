package com.mertkan.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import com.mertkan.model.User;

public class CustomTokenEnhancer implements TokenEnhancer {

	// To add userId to authorization token 
	
	 @Override
	    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
	        User user = (User) authentication.getPrincipal();
	        final Map<String, Object> additionalInfo = new HashMap<>();
	        additionalInfo.put("userId", user.getId());
	        //additionalInfo.put("authorities", user.getAuthorities());
	        ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(additionalInfo);
	        
	        return accessToken;
	    }


}
