package com.pyyh.manager.business.atomizer.dao;

import java.util.List;

import com.pyyh.manager.business.atomizer.pojo.UserPojo;

public interface IUserManagerDao {
	public void add(UserPojo userPojo);
	public int exists(UserPojo userPojo);
	public void delete(UserPojo userPojo);
	public void update(UserPojo userPojo);
	public List<UserPojo> find(UserPojo userPojo);
	public int count(UserPojo userPojo);
}
