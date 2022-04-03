package com.pyyh.manager.business.atomizer.pojo;

public class UserRolePojo {
	private int id;
	private int userIndex;
	private int roleIndex;
	private int[] roleIndexes;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserIndex() {
		return userIndex;
	}
	public void setUserIndex(int userIndex) {
		this.userIndex = userIndex;
	}
	public int getRoleIndex() {
		return roleIndex;
	}
	public void setRoleIndex(int roleIndex) {
		this.roleIndex = roleIndex;
	}
	public int[] getRoleIndexes() {
		return roleIndexes;
	}
	public void setRoleIndexes(int[] roleIndexes) {
		this.roleIndexes = roleIndexes;
	}
}
