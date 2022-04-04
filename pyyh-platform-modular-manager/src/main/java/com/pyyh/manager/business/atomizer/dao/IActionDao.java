package com.pyyh.manager.business.atomizer.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.pyyh.manager.business.atomizer.pojo.ActionPojo;

@Repository
public interface IActionDao {

	public List<ActionPojo> find(ActionPojo ap);
}
