package com.pyyh.manager.util;

import com.alibaba.fastjson.JSONObject;
import com.pyyh.manager.business.atomizer.pojo.ResponsePojo;
import com.pyyh.manager.business.atomizer.pojo.UserPojo;
import com.pyyh.manager.config.ProjectConfig;

public class ContainerUtil {

	public static ResponsePojo response(String action, String message, String state, String jwtToken, Object result){
		ResponsePojo rp = new ResponsePojo();
		rp.setAction(action);
		rp.setMessage(message);
		rp.setState(state);
		rp.setToken(jwtToken);
		rp.setResult(result);
		return rp;
	}
}
