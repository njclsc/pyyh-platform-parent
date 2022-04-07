package com.pyyh.manager.business.atomizer.serviceimp;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.pyyh.manager.business.atomizer.dao.IGroupManagerDao;
import com.pyyh.manager.business.atomizer.pojo.GroupPojo;
import com.pyyh.manager.business.atomizer.pojo.ResponsePojo;
import com.pyyh.manager.business.atomizer.service.IGroupManagerService;
import com.pyyh.manager.config.ProjectConfig;
import com.pyyh.manager.util.ContainerUtil;
@Service("GroupManagerServiceImp")
public class GroupManagerServiceImp implements IGroupManagerService{
	@Autowired
	private IGroupManagerDao gmDao;
	@Override
	public String add(GroupPojo gp, HttpServletRequest request) {
		// TODO Auto-generated method stub
		try{
			JSONObject json = JSONObject.parseObject(ProjectConfig.tokenOperate(2, request.getHeader("jwtToken")));
			gp.setCreator(json.getString("account"));
			gp.setCreatorOrganizationCode(json.getString("organizationCode"));
			if(gmDao.exists(gp) < 1){
				gmDao.add(gp);
				return JSONObject.toJSONString(ContainerUtil.response("/manager/security/group/add", "设备组添加成功", "success", null, null));
			}else{
				return JSONObject.toJSONString(ContainerUtil.response("/manager/security/group/add", "设备组已经存在", "fail", null, null));
			}
		}catch(Exception e){
			e.printStackTrace();
			return JSONObject.toJSONString(ContainerUtil.response("/manager/security/group/add", "设备组添加异常", "fail", null, null));
		}
	}
	@Override
	public String delete(GroupPojo gp, HttpServletRequest request) {
		// TODO Auto-generated method stub
		try{
			gmDao.delete(gp);
			return JSONObject.toJSONString(ContainerUtil.response("/manager/security/group/delete", "设备组删除成功", "success", null, null));
		}catch(Exception e){
			e.printStackTrace();
			return JSONObject.toJSONString(ContainerUtil.response("/manager/security/group/delete", "设备组删除异常", "fail", null, null));
		}
	}
	@Override
	public String update(GroupPojo gp, HttpServletRequest request) {
		// TODO Auto-generated method stub
		try{
			gmDao.update(gp);
			return JSONObject.toJSONString(ContainerUtil.response("/manager/security/group/update", "设备组修改成功", "success", null, null));
		}catch(Exception e){
			e.printStackTrace();
			return JSONObject.toJSONString(ContainerUtil.response("/manager/security/group/update", "设备组修改异常", "fail", null, null));
		}
	}
	@Override
	public String find(GroupPojo gp, HttpServletRequest request) {
		// TODO Auto-generated method stub
		try{
			int page = gp.getPage();
			int rows = gp.getRows();
			int begin = (page - 1) * rows;
			gp.setBegin(begin);
			int total = gmDao.count(gp);
			List<GroupPojo> gps = gmDao.find(gp);
			ResponsePojo rp = ContainerUtil.response("/manager/security/group/find", "设备组查询成功", "success", null, gps);
			rp.setTotal(total);
			return JSONObject.toJSONString(rp);
		}catch(Exception e){
			e.printStackTrace();
			return JSONObject.toJSONString(ContainerUtil.response("/manager/security/group/find", "设备组查询异常", "fail", null, null));
		}
	}

}
