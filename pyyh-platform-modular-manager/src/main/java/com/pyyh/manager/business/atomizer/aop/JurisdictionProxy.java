package com.pyyh.manager.business.atomizer.aop;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pyyh.manager.config.ProjectConfig;
import com.pyyh.manager.util.ContainerUtil;

import redis.clients.jedis.JedisCluster;

@Aspect
@Component
public class JurisdictionProxy {
	@Autowired
	@Qualifier("rediSource")
	private JedisCluster jedis;
	@Autowired
	@Qualifier("actions")
	private HashMap<String, Integer> actions;
	@Pointcut(value = "execution(public * com.pyyh.manager.business.atomizer.controller..*.*(..))")
	public void privilege(){}
	
	@Around(value = "privilege()")
	public Object jurisictionCheck(ProceedingJoinPoint point){
		Object obj = null;
		try{
			Object[] args = point.getArgs();
			HttpServletRequest request = (HttpServletRequest)args[1];
			String info = ProjectConfig.tokenOperate(2, request.getHeader("jwtToken"));
			JSONObject json = JSONObject.parseObject(info);
			String js = jedis.get(json.get("account") + "_#_" + json.get("organizationCode"));
			JSONObject json1 = JSONObject.parseObject(js);
			JSONArray array = json1.getJSONArray("jurisdiction");
			String urlPath = request.getRequestURL().toString();
			int index = urlPath.indexOf(request.getContextPath());
			String path = urlPath.substring(index);
			if(array.contains(actions.get(path))){
				obj = point.proceed(args);
				return obj;
			}else{
				return JSONObject.toJSONString(ContainerUtil.response(path, "权限不足", "fail", null, null));
			}
		}catch(Throwable e){
			e.printStackTrace();
		}
		
		return null;
	}
	
}
