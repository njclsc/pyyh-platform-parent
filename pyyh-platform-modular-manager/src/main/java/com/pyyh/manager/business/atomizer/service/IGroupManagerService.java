package com.pyyh.manager.business.atomizer.service;

import javax.servlet.http.HttpServletRequest;

import com.pyyh.manager.business.atomizer.pojo.GroupPojo;

public interface IGroupManagerService {
	public String add(GroupPojo gp, HttpServletRequest request);
	public String delete(GroupPojo gp, HttpServletRequest request);
	public String update(GroupPojo gp, HttpServletRequest request);
	public String find(GroupPojo gp, HttpServletRequest request);
}
