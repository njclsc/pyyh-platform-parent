package com.pyyh.manager.business.atomizer.pojo;

public class OrganizationPojo {
	private int id;
	private String organizationName;
	private String organizationCode;
	private String creator;
	private String creatorOrganizationCode;
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOrganizationName() {
		return organizationName;
	}
	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}
	public String getOrganizationCode() {
		return organizationCode;
	}
	public void setOrganizationCode(String organizationCode) {
		this.organizationCode = organizationCode;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public String getCreatorOrganizationCode() {
		return creatorOrganizationCode;
	}
	public void setCreatorOrganizationCode(String creatorOrganizationCode) {
		this.creatorOrganizationCode = creatorOrganizationCode;
	}
}
