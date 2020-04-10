package com.github.leonardowiest.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@PropertySource(value = "classpath:/database/configuration-db-${spring.profiles.active}.properties")
@PropertySource(value = "classpath:application-${spring.profiles.active}.properties")
@PropertySource(value = "classpath:application.properties")
@Configuration
public class PropertySources {

}
