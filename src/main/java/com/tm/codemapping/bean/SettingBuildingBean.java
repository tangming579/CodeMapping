package com.tm.codemapping.bean;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class SettingBuildingBean {

	@ApiModelProperty(value = "建筑id")
	private String id;
	private String name;
	private Integer vaild;
	
	@ApiModelProperty(hidden = true)
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
	public Integer getVaild() {
		return vaild;
	}
	public void setVaild(Integer vaild) {
		this.vaild = vaild;
	}
}
