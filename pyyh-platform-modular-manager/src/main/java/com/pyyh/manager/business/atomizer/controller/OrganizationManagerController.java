package com.pyyh.manager.business.atomizer.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pyyh.manager.business.atomizer.pojo.OrganizationPojo;
import com.pyyh.manager.business.atomizer.service.IOrganizationManagerService;

@RestController
@RequestMapping("/security/organization")
public class OrganizationManagerController {
	@Autowired
	@Qualifier("OrganizationManagerServiceImp")
	private IOrganizationManagerService orgService;
	@RequestMapping("add")
	public String add(@RequestBody OrganizationPojo organizationPojo, HttpServletRequest request){
		return orgService.add(organizationPojo, request);
	}
	@RequestMapping("update")
	public String update(@RequestBody OrganizationPojo organizationPojo, HttpServletRequest request){
		return orgService.update(organizationPojo);
	}
	@RequestMapping("delete")
	public String delete(@RequestBody OrganizationPojo organizationPojo, HttpServletRequest request){
		return orgService.delete(organizationPojo);
	}
	@RequestMapping("find")
	public String find(@RequestBody OrganizationPojo organizationPojo, HttpServletRequest request){
		return orgService.find(organizationPojo);
	}
}
