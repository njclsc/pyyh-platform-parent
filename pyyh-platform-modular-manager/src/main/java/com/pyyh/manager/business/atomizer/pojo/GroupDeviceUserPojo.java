package com.pyyh.manager.business.atomizer.pojo;

import java.util.List;

public class GroupDeviceUserPojo {
	private int userIndex;
	private int groupIndex;
	private int[] deviceIndexes;
	private int [] groupIndexes;
	private int page;
	private int rows;
	private int begin;
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public int getBegin() {
		return begin;
	}
	public void setBegin(int begin) {
		this.begin = begin;
	}
	public int getUserIndex() {
		return userIndex;
	}
	public void setUserIndex(int userIndex) {
		this.userIndex = userIndex;
	}
	public int getGroupIndex() {
		return groupIndex;
	}
	public void setGroupIndex(int groupIndex) {
		this.groupIndex = groupIndex;
	}
	public int[] getDeviceIndexes() {
		return deviceIndexes;
	}
	public void setDeviceIndexes(int[] deviceIndexes) {
		this.deviceIndexes = deviceIndexes;
	}
	public int[] getGroupIndexes() {
		return groupIndexes;
	}
	public void setGroupIndexes(int[] groupIndexes) {
		this.groupIndexes = groupIndexes;
	}
}
