package com.github.util;

import java.util.Arrays;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

public final class SecurityBuilder {

	private final HttpSecurity httpSecurity;

	public SecurityBuilder(HttpSecurity httpSecurity) {
		this.httpSecurity = httpSecurity;
	}

	public void build() throws Exception {

		httpSecurity.cors().configurationSource(corsBuilder()).and().httpBasic().and().authorizeRequests()
				.antMatchers("/**").hasRole("USER").and().csrf().disable().headers().frameOptions().disable();
	}

	private CorsConfigurationSource corsBuilder() {

		CorsConfiguration corsConfiguration = new CorsConfiguration().applyPermitDefaultValues();
		corsConfiguration.setAllowedMethods(Arrays.asList(HttpMethod.POST.toString(), HttpMethod.DELETE.toString(),
				HttpMethod.GET.toString(), HttpMethod.PATCH.toString(), HttpMethod.PUT.toString()));
		corsConfiguration.setMaxAge(3600L);

		UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
		urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);

		return urlBasedCorsConfigurationSource;
	}
}
