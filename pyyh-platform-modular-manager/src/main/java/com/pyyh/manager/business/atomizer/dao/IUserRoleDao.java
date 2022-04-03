package com.pyyh.manager.business.atomizer.dao;

import org.springframework.stereotype.Repository;

import com.pyyh.manager.business.atomizer.pojo.UserRolePojo;

@Repository
public interface IUserRoleDao {

	public void add(UserRolePojo urp);
	public void delete(UserRolePojo urp);
}
