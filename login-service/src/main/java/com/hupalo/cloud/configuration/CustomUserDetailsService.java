package com.hupalo.cloud.configuration;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class CustomUserDetailsService implements UserDetailsService {

	private Map<String, CustomUserDetails> users = new HashMap<>();


	@Override
	public CustomUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		CustomUserDetails user = this.users.get(username);
		if (Objects.isNull(user)) {
			throw new UsernameNotFoundException("User not found");
		}
		return user;
	}

	@PostConstruct
	private void init(){
		users.put("admin", new CustomUserDetails("admin", "admin", "ADMIN"));
		users.put("user", new CustomUserDetails("user", "user", "USER"));

	}
}
