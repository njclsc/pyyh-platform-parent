package com.pyyh.manager.business.atomizer.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.pyyh.manager.business.atomizer.pojo.DevicePojo;

@Repository
public interface IDeviceManagerDao {
	public void add(DevicePojo devicePojo);
	public int exists(DevicePojo devicePojo);
	public void delete(DevicePojo devicePojo);
	public void update(DevicePojo devicePojo);
	public List<DevicePojo> find(DevicePojo devicePojo);
	public int count(DevicePojo devicePojo);
}
