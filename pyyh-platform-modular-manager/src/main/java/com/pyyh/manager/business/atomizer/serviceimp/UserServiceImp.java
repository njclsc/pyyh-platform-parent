package com.pyyh.manager.business.atomizer.serviceimp;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.pyyh.manager.business.atomizer.dao.IUserManagerDao;
import com.pyyh.manager.business.atomizer.pojo.ResponsePojo;
import com.pyyh.manager.business.atomizer.pojo.RolePojo;
import com.pyyh.manager.business.atomizer.pojo.UserPojo;
import com.pyyh.manager.business.atomizer.service.IUserService;
import com.pyyh.manager.config.ProjectConfig;
import com.pyyh.manager.util.ContainerUtil;

@Service("UserServiceImp")
public class UserServiceImp implements IUserService{
	@Autowired
	private IUserManagerDao userDao;
	@Override
	public String add(UserPojo userPojo, HttpServletRequest request) {
		// TODO Auto-generated method stub
		try{
			if(userPojo.getPassword() != null && !userPojo.getPassword().equals("") &&userPojo.getPassword().equals(userPojo.getConfirmPassword())&& userDao.exists(userPojo) < 1){
				JSONObject json = JSONObject.parseObject(ProjectConfig.tokenOperate(2, request.getHeader("jwtToken")));
				userPojo.setCreatorOrganizationCode(json.getString("organizationCode"));
				userPojo.setCreator(json.getString("account"));
				userDao.add(userPojo);
				return JSONObject.toJSONString(ContainerUtil.response("/manager/security/user/add", "用户添加成功", "success", null, null));
			}else{
				return JSONObject.toJSONString(ContainerUtil.response("/manager/security/user/add", "用户密码不一致或用户已经存在", "fail", null, null));
			}
		}catch(Exception e){
			e.printStackTrace();
			return JSONObject.toJSONString(ContainerUtil.response("/manager/security/user/add", "用户添加异常", "fail", null, null));
		}
	}
	@Override
	public String delete(UserPojo rolePojo) {
		// TODO Auto-generated method stub
		try{
			userDao.delete(rolePojo);
			return JSONObject.toJSONString(ContainerUtil.response("/manager/security/user/delete", "用户删除成功", "success", null, null));
		}catch(Exception e){
			e.printStackTrace();
			return JSONObject.toJSONString(ContainerUtil.response("/manager/security/user/delete", "用户添加异常", "success", null, null));
		}
	}
	@Override
	public String update(UserPojo rolePojo) {
		// TODO Auto-generated method stub
		try{
			userDao.update(rolePojo);
			return JSONObject.toJSONString(ContainerUtil.response("/manager/security/user/update", "用户修改成功", "success", null, null));
		}catch(Exception e){
			e.printStackTrace();
			return JSONObject.toJSONString(ContainerUtil.response("/manager/security/user/update", "用户修改异常", "fail", null, null));
		}
	}
	@Override
	public String find(UserPojo userPojo) {
		// TODO Auto-generated method stub
		try{
			int page = userPojo.getPage();
			int rows = userPojo.getRows();
			int begin = (page - 1) * rows;
			userPojo.setBegin(begin);
			int total = userDao.count(userPojo);
			List<UserPojo> rps = userDao.find(userPojo);
			ResponsePojo rp = ContainerUtil.response("/manager/security/user/find", "账号查询成功", "success", null, rps);
			rp.setTotal(total);
			return JSONObject.toJSONString(rp);
		}catch(Exception e){
			e.printStackTrace();
			return JSONObject.toJSONString(ContainerUtil.response("/manager/security/user/find", "账号查询异常", "fail", null, null));
		}
	}

}
