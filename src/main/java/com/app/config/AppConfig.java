package com.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan({ "com.app" })
public class AppConfig implements WebMvcConfigurer {

	@Autowired
	private ApplicationContext applicationContext;

	public void addInterceptors(InterceptorRegistry registry) {
		System.out.println("------------ inside interceptor configuration -----------");
		registry.addInterceptor(new AppInterceptor());
	}

	/*public void configureViewResolvers(ViewResolverRegistry registry) {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/views/jsp/");
		viewResolver.setViewNames("*.jsp");
		viewResolver.setOrder(4);
		registry.viewResolver(viewResolver);
	}*/
	
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable("springboot-mvc");
	}

	@Bean
	public ThymeleafViewResolver getThymeleafViewResolver() {
		ThymeleafViewResolver thymeleafViewResolver = new ThymeleafViewResolver();
		thymeleafViewResolver.setTemplateEngine(getSpringTemplateEngine());
		thymeleafViewResolver.setOrder(1);
		thymeleafViewResolver.setViewNames(new String[] { "*.html" });
		thymeleafViewResolver.setExcludedViewNames(new String[] { "*.jsp" });
		return thymeleafViewResolver;
	}

	public SpringTemplateEngine getSpringTemplateEngine() {
		SpringTemplateEngine springTemplateEngine = new SpringTemplateEngine();
		springTemplateEngine.setTemplateResolver(getThymeleafTemplateResolver());
		springTemplateEngine.setEnableSpringELCompiler(true);
		return springTemplateEngine;
	}

	public SpringResourceTemplateResolver getThymeleafTemplateResolver() {
		SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
		templateResolver.setPrefix("classpath:/templates/html/");
		templateResolver.setSuffix(".html");
		templateResolver.setOrder(1);
		templateResolver.setApplicationContext(applicationContext);
		templateResolver.setCacheable(false);
		return templateResolver;
	}

	@Bean
	public InternalResourceViewResolver createJSPViewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/views/jsp/");
		viewResolver.setViewNames("*.jsp");
		viewResolver.setOrder(2);
		return viewResolver;
	}
}
