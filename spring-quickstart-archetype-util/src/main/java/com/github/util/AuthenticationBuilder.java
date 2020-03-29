package com.github.util;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

public final class AuthenticationBuilder {

	private final AuthenticationManagerBuilder authenticationManagerBuilder;

	public AuthenticationBuilder(AuthenticationManagerBuilder auth) {

		super();

		authenticationManagerBuilder = auth;
	}

	public void build() throws Exception {

		this.authenticationManagerBuilder.inMemoryAuthentication().withUser("root").password("{noop}" + "123456")
				.roles("USER", "ADMIN", "ACTUATOR");
	}
}
