package com.pyyh.login.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.pyyh.login.business.atomizer.service.IAuthInterceptorService;
import com.pyyh.login.business.atomizer.serviceimp.AuthInterceptorServiceImp;

@Configuration
public class AppWebMvmConfigure implements WebMvcConfigurer{
	@Autowired
	@Qualifier("AuthInterceptorServiceImp")
	private IAuthInterceptorService authService;
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
		registry.addInterceptor(authService).addPathPatterns("/**")
			.excludePathPatterns("/login/check");
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// TODO Auto-generated method stub
		WebMvcConfigurer.super.addResourceHandlers(registry);
	}

}
