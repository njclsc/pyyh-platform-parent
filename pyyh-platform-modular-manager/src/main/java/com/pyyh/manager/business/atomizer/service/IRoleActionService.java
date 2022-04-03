package com.pyyh.manager.business.atomizer.service;

import java.util.List;

import com.pyyh.manager.business.atomizer.pojo.RoleActionPojo;

public interface IRoleActionService {
	public String add(RoleActionPojo raPojo);
	public String delete(RoleActionPojo raPojo);
}
