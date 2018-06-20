package com.hupalo.cloud.configuration;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

public class CustomTokenEnchancer extends JwtAccessTokenConverter {

	private Logger log = LoggerFactory.getLogger(this.getClass());


	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
		try {

			final Map<String, Object> additionalInfo = new HashMap<>();
			additionalInfo.put("additional_info_key", "additional_info_value");
			((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(additionalInfo);
		} catch (Exception e) {
			log.debug("$$$$$$$$$$$$ Exception in {}: {} - {}", this.getClass().getSimpleName(), e.getClass().getSimpleName(), e.getMessage());
		}
		return super.enhance(accessToken, authentication);
	}

	@Override
	protected Map<String, Object> decode(String token) {
		Map<String, Object> map = super.decode(token);
		// do some custom stuff
		return map;
	}

}
