package com.pyyh.manager.business.atomizer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pyyh.manager.business.atomizer.pojo.UserRolePojo;
import com.pyyh.manager.business.atomizer.service.IUserRoleService;

@RestController
@RequestMapping("/security/userRole")
public class UserRoleController {
	@Autowired
	@Qualifier("UserRoleServiceImp")
	private IUserRoleService urService;
	@RequestMapping("add")
	public String add(@RequestBody UserRolePojo urp){
		return urService.add(urp);
	}
	@RequestMapping("delete")
	public String delete(@RequestBody UserRolePojo urp){
		return urService.delete(urp);
	}
}
