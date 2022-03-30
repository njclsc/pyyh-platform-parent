package com.pyyh.login.config;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.pyyh.login.business.atomizer.serviceimp.AtomizerRealmServiceImp;

@Configuration
public class ShiroConfigure {
	@Bean(name = "shiroFilter")
	public ShiroFilterFactoryBean shiroFilter(@Qualifier("securityManager")DefaultWebSecurityManager securityManager){
		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
		shiroFilterFactoryBean.setSecurityManager(securityManager);
		return shiroFilterFactoryBean;
	}
	@Bean(name = "securityManager")
	public DefaultWebSecurityManager securityManager(@Qualifier("AtomizerRealmServiceImp")AtomizerRealmServiceImp atomizerRealmServiceImp) {
		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
		securityManager.setRealm(atomizerRealmServiceImp);
		return securityManager;
	}
}
