package com.pyyh.manager.business.atomizer.serviceimp;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.pyyh.manager.business.atomizer.dao.IOrganizationManagerDao;
import com.pyyh.manager.business.atomizer.pojo.OrganizationPojo;
import com.pyyh.manager.business.atomizer.pojo.ResponsePojo;
import com.pyyh.manager.business.atomizer.service.IOrganizationManagerService;
import com.pyyh.manager.config.ProjectConfig;
import com.pyyh.manager.util.ContainerUtil;

@Service("OrganizationManagerServiceImp")
public class OrganizationManagerServiceImp implements IOrganizationManagerService{
	@Autowired
	private IOrganizationManagerDao orgDao;
	@Override
	public String add(OrganizationPojo organizationPojo, HttpServletRequest request) {
		// TODO Auto-generated method stub
		try{
			if(orgDao.exists(organizationPojo) < 1){
				JSONObject json = JSONObject.parseObject(ProjectConfig.tokenOperate(2, request.getHeader("jwtToken")));
				organizationPojo.setCreator(json.getString("account"));
				organizationPojo.setCreatorOrganizationCode(json.getString("organizationCode"));
				orgDao.add(organizationPojo);
				return JSONObject.toJSONString(ContainerUtil.response("/manager/security/organization/add", "组织添加成功", "success", null, null));
			}else{
				return JSONObject.toJSONString(ContainerUtil.response("/manager/security/organization/add", "组织编号以存在", "fail", null, null));
			}
		}catch(Exception e){
			e.printStackTrace();
			return JSONObject.toJSONString(ContainerUtil.response("/manager/security/organization/add", "组织添加异常", "fail", null, null));
		}
		
	}
	@Override
	public String update(OrganizationPojo organizationPojo) {
		// TODO Auto-generated method stub
		try{
			orgDao.update(organizationPojo);
			return JSONObject.toJSONString(ContainerUtil.response("/manager/security/organization/add", "组织修改成功", "success", null, null));
		}catch(Exception e){
			e.printStackTrace();
			return JSONObject.toJSONString(ContainerUtil.response("/manager/security/organization/add", "组织修改失败", "fail", null, null));
		}
	}
	@Override
	public String delete(OrganizationPojo organizationPojo) {
		// TODO Auto-generated method stub
		try{
			orgDao.delete(organizationPojo);
			return JSONObject.toJSONString(ContainerUtil.response("/manager/security/organization/delete", "组织删除成功", "success", null, null));
		}catch(Exception e){
			e.printStackTrace();
			return JSONObject.toJSONString(ContainerUtil.response("/manager/security/organization/delete", "组织删除失败", "fail", null, null));
		}
	}
	@Override
	public String find(OrganizationPojo organizationPojo) {
		// TODO Auto-generated method stub
		try{
			int page = organizationPojo.getPage();
			int rows = organizationPojo.getRows();
			int begin = (page - 1) * rows;
			organizationPojo.setBegin(begin);
			List<OrganizationPojo> orgs = orgDao.find(organizationPojo);
			int total = orgDao.count(organizationPojo);
			ResponsePojo rp = ContainerUtil.response("/manager/security/organization/find", "组织查询成功", "success", null, orgs);
			rp.setTotal(total);
			return JSONObject.toJSONString(rp);
		}catch(Exception e){
			e.printStackTrace();
			return JSONObject.toJSONString(ContainerUtil.response("/manager/security/organization/find", "组织查询异常", "success", null, null));
		}
	}

}
