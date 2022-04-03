package com.pyyh.manager.business.atomizer.serviceimp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.pyyh.manager.business.atomizer.dao.IRoleActionDao;
import com.pyyh.manager.business.atomizer.pojo.RoleActionPojo;
import com.pyyh.manager.business.atomizer.service.IRoleActionService;
import com.pyyh.manager.util.ContainerUtil;

@Service("RoleActionServiceImp")
public class RoleActionServiceImp implements IRoleActionService{
	@Autowired
	private IRoleActionDao raDao;
	@Override
	public String add(RoleActionPojo raPojo) {
		// TODO Auto-generated method stub
		try{
			raDao.delete(raPojo);
			raDao.add(raPojo);
			return JSONObject.toJSONString(ContainerUtil.response("/manager/security/roleAction/add", "角色权限添加成功", "success", null, null));
		}catch(Exception e){
			e.printStackTrace();
			return JSONObject.toJSONString(ContainerUtil.response("/manager/security/roleAction/delete", "角色权限添加异常", "fail", null, null));
		}
	}

	@Override
	public String delete(RoleActionPojo raPojo) {
		// TODO Auto-generated method stub
		try{
			raDao.delete(raPojo);
			return JSONObject.toJSONString(ContainerUtil.response("/manager/security/roleAction/add", "角色权限删除成功", "success", null, null));
		}catch(Exception e){
			e.printStackTrace();
			return JSONObject.toJSONString(ContainerUtil.response("/manager/security/roleAction/delete", "角色权限删除异常", "success", null, null));
		}
	}

}
