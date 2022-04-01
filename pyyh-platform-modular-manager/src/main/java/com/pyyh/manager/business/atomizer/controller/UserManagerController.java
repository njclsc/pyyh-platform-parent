package com.pyyh.manager.business.atomizer.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pyyh.manager.business.atomizer.pojo.UserPojo;
import com.pyyh.manager.business.atomizer.service.IUserService;

@RestController
@RequestMapping("/security/user")
public class UserManagerController {
	@Autowired
	@Qualifier("UserServiceImp")
	private IUserService userService;
	@RequestMapping("add")
	public String add(@RequestBody UserPojo user, HttpServletRequest request){
		return userService.add(user, request);
	}
	@RequestMapping("delete")
	public String delete(@RequestBody UserPojo user){
		return userService.delete(user);
	}
	@RequestMapping("update")
	public String update(@RequestBody UserPojo user){
		return userService.update(user);
	}
	@RequestMapping("find")
	public String find(@RequestBody UserPojo user){
		return userService.find(user);
	}
}
