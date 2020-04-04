package com.github.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public final class CustomHandlerInterceptorBuilder extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		if (handler.getClass().equals(HandlerMethod.class)) {

			HandlerMethod handlerMethod = (HandlerMethod) handler;

			log.info("==> CustomHandlerInterceptorBuilder: Executando o método " + handlerMethod.getMethod().getName());
		}

		return true;
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

		if (handler.getClass().equals(HandlerMethod.class)) {

			HandlerMethod handlerMethod = (HandlerMethod) handler;

			log.info("==> CustomHandlerInterceptor: Finalizando execução do método "
					+ handlerMethod.getMethod().getName());
		}

	}
}
