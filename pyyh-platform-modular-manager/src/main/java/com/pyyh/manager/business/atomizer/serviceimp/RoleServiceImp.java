package com.pyyh.manager.business.atomizer.serviceimp;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.pyyh.manager.business.atomizer.dao.IRoleManagerDao;
import com.pyyh.manager.business.atomizer.pojo.ResponsePojo;
import com.pyyh.manager.business.atomizer.pojo.RolePojo;
import com.pyyh.manager.business.atomizer.service.IRoleService;
import com.pyyh.manager.config.ProjectConfig;
import com.pyyh.manager.util.ContainerUtil;
@Service("RoleServiceImp")
public class RoleServiceImp implements IRoleService{
	@Autowired
	private IRoleManagerDao roleDao;
	@Override
	public String add(RolePojo rolePojo, HttpServletRequest request) {
		// TODO Auto-generated method stub
		try{
			JSONObject json = JSONObject.parseObject(ProjectConfig.tokenOperate(2, request.getHeader("jwtToken")));
			rolePojo.setOrganizationCode(json.getString("organizationCode"));
			if(roleDao.exists(rolePojo) < 1){
				rolePojo.setCreator(json.getString("account"));
				roleDao.add(rolePojo);
				return JSONObject.toJSONString(ContainerUtil.response("/manager/security/role/add", "角色添加成功", "success", null, null));
			}else{
				return JSONObject.toJSONString(ContainerUtil.response("/manager/security/role/add", "角色已经存在", "fail", null, null));
			}
		}catch(Exception e){
			e.printStackTrace();
			return JSONObject.toJSONString(ContainerUtil.response("/manager/security/role/add", "角色添加异常", "fail", null, null));
		}
	}
	@Override
	public String delete(RolePojo rolePojo) {
		// TODO Auto-generated method stub
		try{
			roleDao.delete(rolePojo);
			return JSONObject.toJSONString(ContainerUtil.response("/manager/security/role/delete", "角色删除成功", "success", null, null));
		}catch(Exception e){
			e.printStackTrace();
			return JSONObject.toJSONString(ContainerUtil.response("/manager/security/role/delete", "角色删除异常", "fail", null, null));
		}
	}
	@Override
	public String update(RolePojo rolePojo) {
		// TODO Auto-generated method stub
		try{
			roleDao.update(rolePojo);
			return JSONObject.toJSONString(ContainerUtil.response("/manager/security/role/update", "角色修改成功", "success", null, null));
		}catch(Exception e){
			e.printStackTrace();
			return JSONObject.toJSONString(ContainerUtil.response("/manager/security/role/update", "角色修改异常", "fail", null, null));
		}
	}
	@Override
	public String find(RolePojo rolePojo) {
		// TODO Auto-generated method stub
		try{
			int page = rolePojo.getPage();
			int rows = rolePojo.getRows();
			int begin = (page - 1) * rows;
			rolePojo.setBegin(begin);
			int total = roleDao.count(rolePojo);
			List<RolePojo> rps = roleDao.find(rolePojo);
			ResponsePojo rp = ContainerUtil.response("/manager/security/role/find", "组织查询成功", "success", null, rps);
			rp.setTotal(total);
			return JSONObject.toJSONString(rp);
		}catch(Exception e){
			e.printStackTrace();
			return JSONObject.toJSONString(ContainerUtil.response("/manager/security/role/find", "组织查询异常", "fail", null, null));
		}
	}

}
