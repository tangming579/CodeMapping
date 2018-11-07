package com.tm.codemapping.bean;

import java.util.List;

public class SettingBuildingBean {

	private String id;
	private String name;
	private List<SettingFloorBean> floors;
	
	public List<SettingFloorBean> getFloors() {
		return floors;
	}
	public void setFloors(List<SettingFloorBean> floors) {
		this.floors = floors;
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
}
