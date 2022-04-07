package com.pyyh.manager.business.atomizer.service;

import javax.servlet.http.HttpServletRequest;

import com.pyyh.manager.business.atomizer.pojo.DevicePojo;

public interface IDeviceManagerService {
	public String add(DevicePojo devicePojo, HttpServletRequest request);
	public String delelte(DevicePojo devicePojo, HttpServletRequest request);
	public String update(DevicePojo devicePojo, HttpServletRequest request);
	public String find(DevicePojo devicePojo, HttpServletRequest request);
}
