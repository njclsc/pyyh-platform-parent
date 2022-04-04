package com.pyyh.manager.business.atomizer.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pyyh.manager.business.atomizer.pojo.ModularPojo;
import com.pyyh.manager.business.atomizer.service.IJurisdictionService;

@RestController
@RequestMapping("/security/jurisdiction")
public class JurisdictionController {
	@Autowired
	@Qualifier("JurisdictionServiceImp")
	private IJurisdictionService jService;
	@RequestMapping("loadModular")
	public String loadModular(ModularPojo mp, HttpServletRequest request){
		System.out.println("----------ddd->>>>");
		return jService.find(mp);
	}
}
