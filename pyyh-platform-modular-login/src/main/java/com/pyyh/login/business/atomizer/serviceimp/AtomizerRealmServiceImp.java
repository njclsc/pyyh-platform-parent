package com.pyyh.login.business.atomizer.serviceimp;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pyyh.login.business.atomizer.dao.ILoginDao;
import com.pyyh.login.business.atomizer.pojo.UserPojo;

@Service("AtomizerRealmServiceImp")
public class AtomizerRealmServiceImp extends AuthorizingRealm {
	@Autowired
	private ILoginDao loginDao;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken arg0) throws AuthenticationException {
		// TODO Auto-generated method stub
		// 组织编号与账号名称以“_#_”分割
		String[] userInfo = ((String) arg0.getPrincipal()).split("_#_");
		UserPojo user = new UserPojo();
		user.setAccount(userInfo[0]);
		user.setOrganizationCode(userInfo[1]);
		UserPojo _user = loginDao.findUser(user);
		if (_user != null) {
			SimpleAuthenticationInfo authen = new SimpleAuthenticationInfo(
					_user.getAccount() + "_#_" + _user.getOrganizationCode(), _user.getPassword(), this.getName());
			return authen;
		} else {
			return null;
		}
	}

}
