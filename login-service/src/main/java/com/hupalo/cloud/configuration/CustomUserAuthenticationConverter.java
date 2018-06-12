package com.hupalo.cloud.configuration;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.token.AccessTokenConverter;
import org.springframework.security.oauth2.provider.token.DefaultUserAuthenticationConverter;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import static org.springframework.security.oauth2.common.OAuth2AccessToken.REFRESH_TOKEN;

public class CustomUserAuthenticationConverter extends DefaultUserAuthenticationConverter {

	@Override
	public Authentication extractAuthentication(Map<String, ?> map) {
		Authentication auth = super.extractAuthentication(map);
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
		String grantType = request.getParameter(AccessTokenConverter.GRANT_TYPE);
		if (!REFRESH_TOKEN.equals(grantType)) {
			// do something custom
		}
		return auth;
	}
}
