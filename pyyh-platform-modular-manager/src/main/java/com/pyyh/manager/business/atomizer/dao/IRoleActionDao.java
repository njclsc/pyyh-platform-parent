package com.pyyh.manager.business.atomizer.dao;

import org.springframework.stereotype.Repository;

import com.pyyh.manager.business.atomizer.pojo.RoleActionPojo;

@Repository
public interface IRoleActionDao {

	public void add(RoleActionPojo raPojo);
	public void delete(RoleActionPojo raPojo);
}
