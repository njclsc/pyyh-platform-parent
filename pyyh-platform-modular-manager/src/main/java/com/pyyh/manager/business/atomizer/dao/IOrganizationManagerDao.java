package com.pyyh.manager.business.atomizer.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.pyyh.manager.business.atomizer.pojo.OrganizationPojo;

@Repository
public interface IOrganizationManagerDao {

	public void add(OrganizationPojo organizationPojo);
	public int exists(OrganizationPojo organizationPojo);
	public void update(OrganizationPojo organizationPojo);
	public void delete(OrganizationPojo organizationPojo);
	public List<OrganizationPojo> find(OrganizationPojo organizationPojo);
	public int count(OrganizationPojo organizationPojo);
}
