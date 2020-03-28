package com.github.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.http.MediaType;

import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

public class SwaggerDocumentation {

	private String restPackageParam;

	private ApiInfo apiInfoParam;

	public SwaggerDocumentation(String restPackage, ApiInfo apiInfo) {

		super();

		this.restPackageParam = restPackage;

		this.apiInfoParam = apiInfo;
	}

	public Docket produces() {

		List<Parameter> operationParameters = new ArrayList<>();

		operationParameters.add(getParameters());

		return new Docket(DocumentationType.SWAGGER_2).apiInfo(this.apiInfoParam).select()
				.apis(RequestHandlerSelectors.basePackage(this.restPackageParam)).paths(PathSelectors.any()).build()
				.enableUrlTemplating(Boolean.FALSE).produces(getProduceContentTypes())
				.consumes(getConsumeContentTypes()).globalOperationParameters(operationParameters);
	}

	private Parameter getParameters() {

		return new ParameterBuilder().name("Content-Type").description("Content-Type")
				.defaultValue(MediaType.APPLICATION_JSON_VALUE).modelRef(new ModelRef("string")).parameterType("header")
				.required(Boolean.TRUE).build();
	}

	private Set<String> getProduceContentTypes() {

		Set<String> produces = new HashSet<String>();

		produces.add(MediaType.APPLICATION_JSON_VALUE);

		return produces;
	}

	private Set<String> getConsumeContentTypes() {

		Set<String> consumes = new HashSet<String>();

		consumes.add(MediaType.APPLICATION_JSON_VALUE);

		return consumes;
	}

}
