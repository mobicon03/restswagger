package com.sama.restswagger;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@EnableWebMvc
public class SwaggerConfig extends WebMvcConfigurerAdapter  {
	@Bean
	public Docket api() {
		// @formatter:off
		String swaggerBasePackage = "";
		swaggerBasePackage = "com.sama.xpringrestswg4";
		//swaggerBasePackage = "com.sama.xpringrestswg4.StudentRestController.class";
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.select()
				//.apis(RequestHandlerSelectors.basePackage(swaggerBasePackage))
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any())
				.build()
				;
		// @formatter:on
	}

	private ApiInfo apiInfo() {
		String TITLE    = "First Swagger API Document";
		String DESCRIPT = "Testing Swagger variously~~<br>This is Test\nThat is Test";
		String SVC_URL  = "http://swagger.raon.com";
		String EMAIL    = "yongsam.kim@raonsecure.com";
		String LIC_NAME = "RAON License";
		String LIC_URL  = "http://lic.raon.com";

		return new ApiInfoBuilder().title(TITLE)
				.description(DESCRIPT)
				.termsOfServiceUrl(SVC_URL)
				.contact(EMAIL)
				.license(LIC_NAME)
				.licenseUrl(LIC_URL)
				.version("1.0")
				.build();

	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
		registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
	}

/*
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
	    registry.addRedirectViewController("/api", "/swagger-ui.html");
	}
*/

}
