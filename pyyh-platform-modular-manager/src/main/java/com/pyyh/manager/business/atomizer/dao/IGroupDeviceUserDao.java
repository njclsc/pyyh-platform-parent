package com.pyyh.manager.business.atomizer.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.pyyh.manager.business.atomizer.pojo.DevicePojo;
import com.pyyh.manager.business.atomizer.pojo.GroupDeviceUserPojo;
import com.pyyh.manager.business.atomizer.pojo.GroupPojo;

@Repository
public interface IGroupDeviceUserDao {
	public void groupDeviceAdd(GroupDeviceUserPojo gd);
	public void groupDeviceDelete(GroupDeviceUserPojo gd);
	public List<DevicePojo> groupDeviceFind(GroupDeviceUserPojo gd);
	public int groupDeviceCount(GroupDeviceUserPojo gd);
	public void userGroupAdd(GroupDeviceUserPojo gd);
	public void userGroupDelete(GroupDeviceUserPojo gd);
	public List<GroupPojo> userGroupFind(GroupDeviceUserPojo gd);
	public int userGroupCount(GroupDeviceUserPojo gd);
}
