package com.github.leonardowiest.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.github.util.CustomHandlerInterceptorBuilder;

@Configuration
public class ControllerInterceptor implements WebMvcConfigurer {

	private static final String[] WHITELIST = {

	};

	@Override
	public void addInterceptors(InterceptorRegistry registry) {

		registry.addInterceptor(new CustomHandlerInterceptorBuilder()).excludePathPatterns(WHITELIST);

		WebMvcConfigurer.super.addInterceptors(registry);
	}
}
