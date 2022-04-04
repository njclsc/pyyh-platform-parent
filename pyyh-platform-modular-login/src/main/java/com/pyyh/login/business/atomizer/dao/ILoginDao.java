package com.pyyh.login.business.atomizer.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.pyyh.login.business.atomizer.pojo.UserPojo;

@Repository
public interface ILoginDao {

	public UserPojo findUser(UserPojo userPojo);
	public List<Integer> findJurisdiction(UserPojo userPojo);
}
