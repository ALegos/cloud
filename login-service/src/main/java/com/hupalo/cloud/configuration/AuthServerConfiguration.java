package com.hupalo.cloud.configuration;

import java.security.KeyPair;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.PathResource;
import org.springframework.core.io.Resource;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.provider.token.DefaultAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;

@EnableAuthorizationServer
@Configuration
public class AuthServerConfiguration {

	@Value("${security.oauth2.resource.jwt.key-pair.store-password}")
	private String pass;

	@Value("${security.oauth2.resource.jwt.key-pair.alias}")
	private String alias;

	@Value("${security.oauth2.resource.jwt.key-pair.path}")
	private String path;

	@Bean
	public JwtAccessTokenConverter jwtAccessTokenConverter() {
		JwtAccessTokenConverter converter = new CustomTokenEnchancer();
		converter.setAccessTokenConverter(accessTokenConverter());
		KeyPair keyPair = new KeyStoreKeyFactory(
				this.getKeyResource(path),
				pass.toCharArray())
				.getKeyPair(alias);
		converter.setKeyPair(keyPair);
		return converter;
	}

	private DefaultAccessTokenConverter accessTokenConverter() {
		DefaultAccessTokenConverter tokenConverter = new DefaultAccessTokenConverter();
		tokenConverter.setUserTokenConverter(new CustomUserAuthenticationConverter());
		return tokenConverter;
	}

	private Resource getKeyResource(String path){
		Resource resource = new PathResource("config/" + path);
		if (!resource.exists()){
			resource = new ClassPathResource(path);
		}
		return resource;
	}

}
