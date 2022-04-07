package com.pyyh.manager.business.atomizer.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pyyh.manager.business.atomizer.pojo.DevicePojo;
import com.pyyh.manager.business.atomizer.service.IDeviceManagerService;

@RestController
@RequestMapping("/terminal/device")
public class DeviceManagerController {
	@Autowired
	@Qualifier("DeviceManagerServiceImp")
	private IDeviceManagerService dmService;
	@RequestMapping("add")
	public String add(@RequestBody DevicePojo devicePojo, HttpServletRequest request){
		return dmService.add(devicePojo, request);
	}
	@RequestMapping("delete")
	public String delete(@RequestBody DevicePojo devicePojo, HttpServletRequest request){
		return dmService.delelte(devicePojo, request);
	}
	@RequestMapping("update")
	public String update(@RequestBody DevicePojo devicePojo, HttpServletRequest request){
		return dmService.update(devicePojo, request);
	}
	@RequestMapping("find")
	public String find(@RequestBody DevicePojo devicePojo, HttpServletRequest request){
		return dmService.find(devicePojo, request);
	}
}
