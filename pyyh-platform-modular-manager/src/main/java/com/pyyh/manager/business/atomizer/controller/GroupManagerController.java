package com.pyyh.manager.business.atomizer.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pyyh.manager.business.atomizer.pojo.GroupPojo;
import com.pyyh.manager.business.atomizer.service.IGroupManagerService;

@RestController
@RequestMapping("/security/group")
public class GroupManagerController {
	@Autowired
	@Qualifier("GroupManagerServiceImp")
	private IGroupManagerService gmService;
	@RequestMapping("add")
	public String add(@RequestBody GroupPojo gp, HttpServletRequest req){
		return gmService.add(gp, req);
	}
	@RequestMapping("delete")
	public String delete(@RequestBody GroupPojo gp, HttpServletRequest req){
		return gmService.delete(gp, req);
	}
	@RequestMapping("update")
	public String update(@RequestBody GroupPojo gp, HttpServletRequest req){
		return gmService.update(gp, req);
	}
	@RequestMapping("find")
	public String find(@RequestBody GroupPojo gp, HttpServletRequest req){
		return gmService.find(gp, req);
	}
}
