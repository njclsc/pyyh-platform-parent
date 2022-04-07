package com.pyyh.manager.business.atomizer.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.pyyh.manager.business.atomizer.pojo.GroupPojo;

@Repository
public interface IGroupManagerDao {

	public void add(GroupPojo gp);
	public int exists(GroupPojo gp);
	public void delete(GroupPojo gp);
	public void update(GroupPojo gp);
	public List<GroupPojo> find(GroupPojo gp);
	public int count(GroupPojo gp);
}
