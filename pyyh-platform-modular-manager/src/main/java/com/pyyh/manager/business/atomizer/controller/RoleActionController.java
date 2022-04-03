package com.pyyh.manager.business.atomizer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pyyh.manager.business.atomizer.pojo.RoleActionPojo;
import com.pyyh.manager.business.atomizer.service.IRoleActionService;

@RestController
@RequestMapping("/security/roleAction")
public class RoleActionController {
	@Autowired
	@Qualifier("RoleActionServiceImp")
	private IRoleActionService raService;
	@RequestMapping("add")
	public String add(@RequestBody RoleActionPojo rap){
		return raService.add(rap);
	}
	@RequestMapping("delete")
	public String delete(@RequestBody RoleActionPojo rap){
		return raService.delete(rap);
	}
	
}
