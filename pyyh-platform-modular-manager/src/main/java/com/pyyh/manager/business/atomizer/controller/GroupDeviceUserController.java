package com.pyyh.manager.business.atomizer.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pyyh.manager.business.atomizer.pojo.GroupDeviceUserPojo;
import com.pyyh.manager.business.atomizer.service.IGroupDeviceUserService;

@RestController
@RequestMapping("/security/groupDeviceUser")
public class GroupDeviceUserController {

	@Autowired
	@Qualifier("GroupDeviceUserServiceImp")
	private IGroupDeviceUserService gduService;
	
	@RequestMapping("groupDeviceAdd")
	public String groupDeviceAdd(@RequestBody GroupDeviceUserPojo gdup, HttpServletRequest req){
		return gduService.groupDeviceAdd(gdup, req);
	}
	@RequestMapping("groupDeviceDelete")
	public String groupDeviceDelete(@RequestBody GroupDeviceUserPojo gd, HttpServletRequest req){
		return gduService.groupDeviceDelete(gd, req);
	}
	@RequestMapping("groupDeviceFind")
	public String groupDeviceFind(@RequestBody GroupDeviceUserPojo gd, HttpServletRequest req){
		return gduService.groupDeviceFind(gd, req);
	}
	@RequestMapping("userGroupAdd")
	public String userGroupAdd(@RequestBody GroupDeviceUserPojo gd, HttpServletRequest req){
		return gduService.userGroupAdd(gd, req);				
	}
	@RequestMapping("userGroupDelete")
	public String userGroupDelete(@RequestBody GroupDeviceUserPojo gd, HttpServletRequest req){
		return gduService.userGroupDelete(gd, req);				
	}
	@RequestMapping("userGroupFind")
	public String userGroupFind(@RequestBody GroupDeviceUserPojo gd, HttpServletRequest req){
		return gduService.userGroupFind(gd, req);
	}
}
