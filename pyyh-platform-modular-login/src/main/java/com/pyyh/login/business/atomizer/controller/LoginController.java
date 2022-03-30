package com.pyyh.login.business.atomizer.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pyyh.login.business.atomizer.pojo.UserPojo;
import com.pyyh.login.business.atomizer.service.ILoginService;

@RestController
@RequestMapping("/login")
public class LoginController {
	@Autowired
	@Qualifier("LoginServiceImp")
	private ILoginService loginService;
	@RequestMapping("check")
	public String check(@RequestBody UserPojo userPojo, HttpServletResponse response){
		return loginService.check(userPojo, response);
	}
	@RequestMapping("loginOut")
	public String loginOut(@RequestBody UserPojo userPojo){
		return loginService.loginOut(userPojo);
	}
}
