package com.pyyh.login.business.atomizer.service;

import javax.servlet.http.HttpServletResponse;

import com.pyyh.login.business.atomizer.pojo.UserPojo;

public interface ILoginService {

	public String check(UserPojo userPojo, HttpServletResponse response);
	public String loginOut(UserPojo userPojo);
}
