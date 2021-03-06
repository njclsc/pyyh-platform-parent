package com.pyyh.login.business.atomizer.serviceimp;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.pyyh.login.business.atomizer.dao.ILoginDao;
import com.pyyh.login.business.atomizer.pojo.UserPojo;
import com.pyyh.login.business.atomizer.service.ILoginService;
import com.pyyh.login.config.ProjectConfig;
import com.pyyh.login.util.ContainerUtil;

import redis.clients.jedis.JedisCluster;

@Service("LoginServiceImp")
public class LoginServiceImp implements ILoginService{
	@Autowired
	private ILoginDao loginDao;
	@Autowired
	@Qualifier("rediSource")
	private JedisCluster jedis;
	@Override
	public String check(UserPojo userPojo, HttpServletResponse response) {
		// TODO Auto-generated method stub
		try{
			String key = userPojo.getAccount() + "_#_" + userPojo.getOrganizationCode();
			UsernamePasswordToken token = new UsernamePasswordToken(key, userPojo.getPassword());
			Subject subject = SecurityUtils.getSubject();
			subject.login(token);
			userPojo.setPassword("");
			userPojo.setLogin(true);
			String jwtToken = ProjectConfig.tokenOperate(1, userPojo);
			response.addCookie(new Cookie("jwtToken", jwtToken));
			
			UserPojo _userPojo = loginDao.findUser(userPojo);
			_userPojo.setLogin(true);
			_userPojo.setPassword("");
			List<Integer> actions = loginDao.findJurisdiction(_userPojo);
			_userPojo.setJurisdiction(actions);
			jedis.set(key, JSONObject.toJSONString(_userPojo));
			jedis.pexpire(key, ProjectConfig.getJWT_EXPIRES());
			System.out.println(JSONObject.toJSONString(_userPojo));
			return JSONObject.toJSONString(ContainerUtil.response("/login/login/check", "????????????", "success", jwtToken, null));
		}catch(UnknownAccountException e){
			return JSONObject.toJSONString(ContainerUtil.response("/login/login/check", "???????????????", "fail", null, null));
		}catch(IncorrectCredentialsException e){
			return JSONObject.toJSONString(ContainerUtil.response("/login/login/check", "????????????", "fail", null, null));
		}
	}
	@Override
	public String loginOut(UserPojo userPojo) {
		// TODO Auto-generated method stub
		try{
			String key = userPojo.getAccount() + "_#_" + userPojo.getOrganizationCode();
			jedis.del(key);
			return JSONObject.toJSONString(ContainerUtil.response("/login/login/loginOut", "??????", "success", null, null));
		}catch(Exception e){
			e.printStackTrace();
			return "";
		}
	}

}
