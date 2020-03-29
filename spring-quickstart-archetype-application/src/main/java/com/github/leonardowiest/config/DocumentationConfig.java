package com.github.leonardowiest.config;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.github.util.SwaggerDocumentation;
import com.github.util.constants.GlobalConstants;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.BasicAuth;
import springfox.documentation.service.Contact;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Component(value = "documentationConfigComponent")
public class DocumentationConfig {

	@Bean(name = "swaggerConfigurationBean")
	@Lazy
	public Docket swaggerConfiguration() {

		return new SwaggerDocumentation(GlobalConstants.PKG_REST,
				new ApiInfo("REST API - Spring Quickstart Archetype", "Documentation", "1.0", "Terms of service",
						new Contact("Leonardo Wiest", "https://github.com/LeonardoWiest/", "leonardowiest@hotmail.com"),
						"", "", new ArrayList<>())).produces().groupName("Spring Quickstart Archetype")
								.securitySchemes(Arrays.asList(new BasicAuth("basicAuth")));
	}
}
