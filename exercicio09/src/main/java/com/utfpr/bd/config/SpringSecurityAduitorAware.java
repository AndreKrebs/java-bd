package com.utfpr.bd.config;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

public class SpringSecurityAduitorAware implements AuditorAware<String> {
	@Override
	public Optional<String> getCurrentAuditor() {
		Authentication auth = SecurityContextHolder
				.getContext()
				.getAuthentication();
		if (auth == null || !auth.isAuthenticated()){
			return null;
		}
	    return Optional.of(((User) auth.getPrincipal()).getUsername());
	}

}