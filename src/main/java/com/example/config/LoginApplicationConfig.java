package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "com.example" })
@Import(value = { LoginSecurityConfig.class })
public class LoginApplicationConfig {

	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		System.out.println("***********Internal View Resolver*************" + viewResolver);
		return viewResolver;
	}
	
	@Bean
	public ReloadableResourceBundleMessageSource messageSource() {
		ReloadableResourceBundleMessageSource resource = new ReloadableResourceBundleMessageSource();
		resource.setDefaultEncoding("UTF-8");
		resource.setUseCodeAsDefaultMessage(true);
		 resource.setBasename("classpath:pmg");
		//resource.setBasename("file:///D:\\git\\properties\\config\\pmg");
		resource.setCacheSeconds(10);
		System.out.println("********************************");
		System.out.println("Returning the Message Resource:" + resource.toString());
		System.out.println("********************************");
		// logger.info("Value:::::" + resource.getMessage("name",
		// null,Locale.getDefault()));
		return resource;
	}

}
