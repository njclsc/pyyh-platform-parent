package com.pyyh.login.util;

import com.pyyh.login.business.atomizer.pojo.ResponsePojo;

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
