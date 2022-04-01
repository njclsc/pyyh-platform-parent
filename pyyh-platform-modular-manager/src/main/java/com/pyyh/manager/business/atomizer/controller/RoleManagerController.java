package com.pyyh.manager.business.atomizer.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pyyh.manager.business.atomizer.pojo.RolePojo;
import com.pyyh.manager.business.atomizer.service.IRoleService;

@RestController
@RequestMapping("/security/role")
public class RoleManagerController {
	@Autowired
	@Qualifier("RoleServiceImp")
	private IRoleService roleService;
	@RequestMapping("add")
	public String add(@RequestBody RolePojo rolePojo, HttpServletRequest request){
		return roleService.add(rolePojo, request);
	}
	@RequestMapping("delete")
	public String delete(@RequestBody RolePojo rolePojo){
		return roleService.delete(rolePojo);
	}
	@RequestMapping("update")
	public String update(@RequestBody RolePojo rolePojo){
		return roleService.update(rolePojo);
	}
	@RequestMapping("find")
	public String find(@RequestBody RolePojo rolePojo){
		return roleService.find(rolePojo);
	}
}
