package com.pyyh.manager.business.atomizer.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.pyyh.manager.business.atomizer.pojo.RolePojo;

@Repository
public interface IRoleManagerDao {

	public void add(RolePojo rolePojo);
	public int exists(RolePojo rolePojo);
	public void update(RolePojo rolePojo);
	public void delete(RolePojo rolePojo);
	public List<RolePojo> find(RolePojo rolePojo);
	public int count(RolePojo rolePojo);
}
