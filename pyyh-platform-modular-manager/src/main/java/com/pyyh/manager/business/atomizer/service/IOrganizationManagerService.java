package com.pyyh.manager.business.atomizer.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestBody;

import com.pyyh.manager.business.atomizer.pojo.OrganizationPojo;

public interface IOrganizationManagerService {

	public String add(@RequestBody OrganizationPojo organizationPojo, HttpServletRequest request);
	public String update(OrganizationPojo organizationPojo);
	public String delete(OrganizationPojo organizationPojo);
	public String find(OrganizationPojo organizationPojo);
}
