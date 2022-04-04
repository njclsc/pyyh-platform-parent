package com.pyyh.manager.business.atomizer.pojo;

import java.util.List;

public class ModularPojo {
	private int id;
	private String modularName;
	private int modularIndex;
	private String modularLevel;
	private int parentIndex;
	private String url;
	private List<ModularPojo> mps;
	public List<ModularPojo> getMps() {
		return mps;
	}
	public void setMps(List<ModularPojo> mps) {
		this.mps = mps;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getModularName() {
		return modularName;
	}
	public void setModularName(String modularName) {
		this.modularName = modularName;
	}
	public int getModularIndex() {
		return modularIndex;
	}
	public void setModularIndex(int modularIndex) {
		this.modularIndex = modularIndex;
	}
	public String getModularLevel() {
		return modularLevel;
	}
	public void setModularLevel(String modularLevel) {
		this.modularLevel = modularLevel;
	}
	public int getParentIndex() {
		return parentIndex;
	}
	public void setParentIndex(int parentIndex) {
		this.parentIndex = parentIndex;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
}
