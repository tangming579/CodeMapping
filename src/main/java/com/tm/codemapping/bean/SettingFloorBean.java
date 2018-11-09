package com.tm.codemapping.bean;

import java.util.List;

public class SettingFloorBean {
	
	private String id;
	private String name;
	private String buildingId;
	private Integer vaild;
	private List<SettingAreaBean> areas;
	
	public List<SettingAreaBean> getAreas() {
		return areas;
	}
	public void setAreas(List<SettingAreaBean> areas) {
		this.areas = areas;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBuildingId() {
		return buildingId;
	}
	public void setBuildingId(String buildingId) {
		this.buildingId = buildingId;
	}
	public Integer getVaild() {
		return vaild;
	}
	public void setVaild(Integer vaild) {
		this.vaild = vaild;
	}
}
