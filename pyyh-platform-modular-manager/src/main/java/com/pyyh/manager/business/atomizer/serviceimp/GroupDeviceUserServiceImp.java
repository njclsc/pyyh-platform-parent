package com.pyyh.manager.business.atomizer.serviceimp;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.pyyh.manager.business.atomizer.dao.IGroupDeviceUserDao;
import com.pyyh.manager.business.atomizer.pojo.DevicePojo;
import com.pyyh.manager.business.atomizer.pojo.GroupDeviceUserPojo;
import com.pyyh.manager.business.atomizer.pojo.GroupPojo;
import com.pyyh.manager.business.atomizer.pojo.ResponsePojo;
import com.pyyh.manager.business.atomizer.service.IGroupDeviceUserService;
import com.pyyh.manager.util.ContainerUtil;

@Service("GroupDeviceUserServiceImp")
public class GroupDeviceUserServiceImp implements IGroupDeviceUserService{
	@Autowired
	private IGroupDeviceUserDao gduDao;
	@Override
	public String groupDeviceAdd(GroupDeviceUserPojo gd, HttpServletRequest req) {
		// TODO Auto-generated method stub
		try{
			gduDao.groupDeviceDelete(gd);
			gduDao.groupDeviceAdd(gd);
			return JSONObject.toJSONString(ContainerUtil.response("/manager/security/groupDeviceUser/groupDeviceAdd", "组设备关联成功", "success", null, null));
		}catch(Exception e){
			e.printStackTrace();
			return JSONObject.toJSONString(ContainerUtil.response("/manager/security/groupDeviceUser/groupDeviceAdd", "组设备关联失败", "fail", null, null));
		}
	}
	@Override
	public String groupDeviceDelete(GroupDeviceUserPojo gd, HttpServletRequest req) {
		// TODO Auto-generated method stub
		try{
			gduDao.groupDeviceDelete(gd);
			return JSONObject.toJSONString(ContainerUtil.response("/manager/security/groupDeviceUser/groupDeviceDelete", "组设备解绑成功", "success", null, null));
		}catch(Exception e){
			e.printStackTrace();
			return JSONObject.toJSONString(ContainerUtil.response("/manager/security/groupDeviceUser/groupDeviceDelete", "组设备解绑失败", "fail", null, null));
		}
	}
	@Override
	public String groupDeviceFind(GroupDeviceUserPojo gd, HttpServletRequest req) {
		// TODO Auto-generated method stub
		try{
			int page = gd.getPage();
			int rows = gd.getRows();
			int begin = (page - 1) * rows;
			gd.setBegin(begin);
			int total = gduDao.groupDeviceCount(gd);
			List<DevicePojo> dp = gduDao.groupDeviceFind(gd);
			ResponsePojo rp = ContainerUtil.response("/manager/security/groupDeviceUser/groupDevicefind", "组设备查询成功", "success", null, dp);
			rp.setTotal(total);
			return JSONObject.toJSONString(rp);
		}catch(Exception e){
			e.printStackTrace();
			return JSONObject.toJSONString(ContainerUtil.response("/manager/security/groupDeviceUser/groupDevicefind", "组设备查询异常", "fail", null, null));
		}
	}
	@Override
	public String userGroupAdd(GroupDeviceUserPojo gd, HttpServletRequest req) {
		// TODO Auto-generated method stub
		try{
			gduDao.userGroupDelete(gd);
			gduDao.userGroupAdd(gd);
			return JSONObject.toJSONString(ContainerUtil.response("/manager/security/groupDeviceUser/userGroupAdd", "用户组关联成功", "success", null, null));
		}catch(Exception e){
			e.printStackTrace();
			return JSONObject.toJSONString(ContainerUtil.response("/manager/security/groupDeviceUser/userGroupAdd", "用户组关联异常", "fail", null, null));
		}
	}
	@Override
	public String userGroupDelete(GroupDeviceUserPojo gd, HttpServletRequest req) {
		// TODO Auto-generated method stub
		try{
			gduDao.userGroupDelete(gd);
			return JSONObject.toJSONString(ContainerUtil.response("/manager/security/groupDeviceUser/userGroupDelete", "用户组解绑成功", "success", null, null));
		}catch(Exception e){
			e.printStackTrace();
			return JSONObject.toJSONString(ContainerUtil.response("/manager/security/groupDeviceUser/userGroupDelete", "用户组解绑异常", "fail", null, null));
		}
	}
	@Override
	public String userGroupFind(GroupDeviceUserPojo gd, HttpServletRequest req) {
		// TODO Auto-generated method stub
		try{
			int page = gd.getPage();
			int rows = gd.getRows();
			int begin = (page - 1) * rows;
			gd.setBegin(begin);
			int total = gduDao.userGroupCount(gd);
			List<GroupPojo> dp = gduDao.userGroupFind(gd);
			ResponsePojo rp = ContainerUtil.response("/manager/security/groupDeviceUser/groupDevicefind", "用户组查询成功", "success", null, dp);
			rp.setTotal(total);
			return JSONObject.toJSONString(rp);
		}catch(Exception e){
			e.printStackTrace();
			return JSONObject.toJSONString(ContainerUtil.response("/manager/security/groupDeviceUser/groupDevicefind", "用户组查询异常", "fail", null, null));
		}
	}

}
