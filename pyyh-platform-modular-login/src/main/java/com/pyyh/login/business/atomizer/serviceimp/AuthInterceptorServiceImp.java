package com.pyyh.login.business.atomizer.serviceimp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.pyyh.login.business.atomizer.service.IAuthInterceptorService;
import com.pyyh.login.config.ProjectConfig;

import redis.clients.jedis.JedisCluster;

@Service("AuthInterceptorServiceImp")
public class AuthInterceptorServiceImp implements IAuthInterceptorService{
	@Autowired
	@Qualifier("rediSource")
	private JedisCluster jedis;
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		String info = ProjectConfig.tokenOperate(2, request.getHeader("jwtToken"));
		JSONObject json = JSONObject.parseObject(info);
		String js = jedis.get(json.get("account") + "_#_" + json.get("organizationCode"));
		return JSONObject.parseObject(js).getBooleanValue("login");
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		IAuthInterceptorService.super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		IAuthInterceptorService.super.afterCompletion(request, response, handler, ex);
	}

}
