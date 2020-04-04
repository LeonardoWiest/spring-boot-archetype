package com.github.leonardowiest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.github.util.CustomHandlerInterceptorBuilder;

@Configuration
@EnableAspectJAutoProxy
public class RequestProcessingTimeInterceptor {

	@Bean
	public CustomHandlerInterceptorBuilder build() {

		return new CustomHandlerInterceptorBuilder();
	}

}
