package com.pyyh.manager.business.atomizer.pojo;

import java.util.List;

public class RoleActionPojo {
	private int id;
	private int roleIndex;
	private int actionIndex;
	private int[] actionIndexes;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRoleIndex() {
		return roleIndex;
	}
	public void setRoleIndex(int roleIndex) {
		this.roleIndex = roleIndex;
	}
	public int getActionIndex() {
		return actionIndex;
	}
	public void setActionIndex(int actionIndex) {
		this.actionIndex = actionIndex;
	}
	public int[] getActionIndexes() {
		return actionIndexes;
	}
	public void setActionIndexes(int[] actionIndexes) {
		this.actionIndexes = actionIndexes;
	}

}
