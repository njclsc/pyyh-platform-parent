package com.pyyh.manager.business.atomizer.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.pyyh.manager.business.atomizer.pojo.ModularPojo;

@Repository
public interface IJurisdictionDao {

	public List<ModularPojo> find(ModularPojo mp);
}
