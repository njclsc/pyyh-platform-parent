package com.pyyh.manager.business.atomizer.service;

import javax.servlet.http.HttpServletRequest;

import com.pyyh.manager.business.atomizer.pojo.UserPojo;

public interface IUserService {
	public String add(UserPojo userPojo, HttpServletRequest request);
	public String delete(UserPojo userPojo);
	public String update(UserPojo userPojo);
	public String find(UserPojo userPojo);
}
