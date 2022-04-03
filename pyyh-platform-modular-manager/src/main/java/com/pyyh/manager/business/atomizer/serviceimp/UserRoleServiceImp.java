package com.pyyh.manager.business.atomizer.serviceimp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.pyyh.manager.business.atomizer.dao.IUserRoleDao;
import com.pyyh.manager.business.atomizer.pojo.UserRolePojo;
import com.pyyh.manager.business.atomizer.service.IUserRoleService;
import com.pyyh.manager.util.ContainerUtil;

@Service("UserRoleServiceImp")
public class UserRoleServiceImp implements IUserRoleService{
	@Autowired
	private IUserRoleDao urDao;
	@Override
	public String add(UserRolePojo urp) {
		// TODO Auto-generated method stub
		try{
			urDao.delete(urp);
			urDao.add(urp);
			return JSONObject.toJSONString(ContainerUtil.response("/manager/security/userRole/add", "用户角色添加成功", "success", null, null));
		}catch(Exception e){
			e.printStackTrace();
			return JSONObject.toJSONString(ContainerUtil.response("/manager/security/userRole/add", "用户角色添加异常", "fail", null, null));
		}
	}

	@Override
	public String delete(UserRolePojo urp) {
		// TODO Auto-generated method stub
		try{
			urDao.delete(urp);
			return JSONObject.toJSONString(ContainerUtil.response("/manager/security/userRole/add", "用户角色删除成功", "success", null, null));
		}catch(Exception e){
			e.printStackTrace();
			return JSONObject.toJSONString(ContainerUtil.response("/manager/security/userRole/add", "用户角色删除异常", "fail", null, null));
		}
	}

}
