package com.pyyh.manager.business.atomizer.pojo;

public class DevicePojo {
	private int id;
	private String deviceCode;
	private int status;
	private String organizationCode;
	private String startTime;
	private String sotpTime;
	private String runTime;
	private String rate;
	private String grar;
	private String level;
	private int page;
	private int rows;
	private int begin;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDeviceCode() {
		return deviceCode;
	}
	public void setDeviceCode(String deviceCode) {
		this.deviceCode = deviceCode;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getOrganizationCode() {
		return organizationCode;
	}
	public void setOrganizationCode(String organizationCode) {
		this.organizationCode = organizationCode;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getSotpTime() {
		return sotpTime;
	}
	public void setSotpTime(String sotpTime) {
		this.sotpTime = sotpTime;
	}
	public String getRunTime() {
		return runTime;
	}
	public void setRunTime(String runTime) {
		this.runTime = runTime;
	}
	public String getRate() {
		return rate;
	}
	public void setRate(String rate) {
		this.rate = rate;
	}
	public String getGrar() {
		return grar;
	}
	public void setGrar(String grar) {
		this.grar = grar;
	}
	public String getLevel() {
		return level;
	}
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
	public void setLevel(String level) {
		this.level = level;
	}
}
