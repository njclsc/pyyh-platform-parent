package com.pyyh.manager.business.atomizer.service;

import javax.servlet.http.HttpServletRequest;

import com.pyyh.manager.business.atomizer.pojo.GroupDeviceUserPojo;

public interface IGroupDeviceUserService {
	public String groupDeviceAdd(GroupDeviceUserPojo gd, HttpServletRequest req);
	public String groupDeviceDelete(GroupDeviceUserPojo gd, HttpServletRequest req);
	public String groupDeviceFind(GroupDeviceUserPojo gd, HttpServletRequest req);
	public String userGroupAdd(GroupDeviceUserPojo gd, HttpServletRequest req);
	public String userGroupDelete(GroupDeviceUserPojo gd, HttpServletRequest req);
	public String userGroupFind(GroupDeviceUserPojo gd, HttpServletRequest req);
}
