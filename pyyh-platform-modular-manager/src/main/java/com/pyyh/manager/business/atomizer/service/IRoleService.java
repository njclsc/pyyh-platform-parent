package com.pyyh.manager.business.atomizer.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.pyyh.manager.business.atomizer.pojo.RolePojo;

public interface IRoleService {
	public String add(RolePojo rolePojo, HttpServletRequest request);
	public String delete(RolePojo rolePojo);
	public String update(RolePojo rolePojo);
	public String find(RolePojo rolePojo);
}
