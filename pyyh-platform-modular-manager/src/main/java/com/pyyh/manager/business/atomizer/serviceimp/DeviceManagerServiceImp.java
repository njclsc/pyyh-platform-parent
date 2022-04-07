package com.pyyh.manager.business.atomizer.serviceimp;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.pyyh.manager.business.atomizer.dao.IDeviceManagerDao;
import com.pyyh.manager.business.atomizer.pojo.DevicePojo;
import com.pyyh.manager.business.atomizer.pojo.ResponsePojo;
import com.pyyh.manager.business.atomizer.service.IDeviceManagerService;
import com.pyyh.manager.config.ProjectConfig;
import com.pyyh.manager.util.ContainerUtil;

@Service("DeviceManagerServiceImp")
public class DeviceManagerServiceImp implements IDeviceManagerService{
	@Autowired
	private IDeviceManagerDao dmDao;
	@Override
	public String add(DevicePojo devicePojo, HttpServletRequest request) {
		// TODO Auto-generated method stub
		try{
			JSONObject json = JSONObject.parseObject(ProjectConfig.tokenOperate(2, request.getHeader("jwtToken")));
			devicePojo.setOrganizationCode(json.getString("organizationCode"));
			if(dmDao.exists(devicePojo) < 1){
				dmDao.add(devicePojo);
				return JSONObject.toJSONString(ContainerUtil.response("/manager/terminal/device/add", "设备添加成功", "success", null, null));
			}else{
				return JSONObject.toJSONString(ContainerUtil.response("/manager/terminal/device/add", "设备已经存在", "fail", null, null));
			}
		}catch(Exception e){
			e.printStackTrace();
			return JSONObject.toJSONString(ContainerUtil.response("/manager/terminal/device/add", "设备添加异常", "fail", null, null));
		}
	}
	@Override
	public String delelte(DevicePojo devicePojo, HttpServletRequest request) {
		// TODO Auto-generated method stub
		try{
			JSONObject json = JSONObject.parseObject(ProjectConfig.tokenOperate(2, request.getHeader("jwtToken")));
			devicePojo.setOrganizationCode(json.getString("organizationCode"));
			dmDao.delete(devicePojo);
			return JSONObject.toJSONString(ContainerUtil.response("/manager/terminal/device/delete", "设备删除成功", "success", null, null));
		}catch(Exception e){
			e.printStackTrace();
			return JSONObject.toJSONString(ContainerUtil.response("/manager/terminal/device/delete", "设备删除异常", "fail", null, null));
		}
	}
	@Override
	public String update(DevicePojo devicePojo, HttpServletRequest request) {
		// TODO Auto-generated method stub
		try{
			JSONObject json = JSONObject.parseObject(ProjectConfig.tokenOperate(2, request.getHeader("jwtToken")));
			devicePojo.setOrganizationCode(json.getString("organizationCode"));
			dmDao.update(devicePojo);
			return JSONObject.toJSONString(ContainerUtil.response("/manager/terminal/device/update", "设备修改成功", "success", null, null));
		}catch(Exception e){
			e.printStackTrace();
			return JSONObject.toJSONString(ContainerUtil.response("/manager/terminal/device/update", "设备修改异常", "fail", null, null));
		}
	}
	public String find(DevicePojo devicePojo, HttpServletRequest request){
		try{
			int page = devicePojo.getPage();
			int rows = devicePojo.getRows();
			int begin = (page - 1) * rows;
			devicePojo.setBegin(begin);
			JSONObject json = JSONObject.parseObject(ProjectConfig.tokenOperate(2, request.getHeader("jwtToken")));
			devicePojo.setOrganizationCode(json.getString("organizationCode"));
			int total = dmDao.count(devicePojo);
			List<DevicePojo> dps = dmDao.find(devicePojo);
			ResponsePojo rp = ContainerUtil.response("/manager/terminal/device/find", "设备查询成功", "success", null, dps);
			rp.setTotal(total);
			return JSONObject.toJSONString(rp);
		}catch(Exception e){
			e.printStackTrace();
			return JSONObject.toJSONString(ContainerUtil.response("/manager/terminal/device/find", "设备查询异常", "fail", null, null));
		}
	}

}
