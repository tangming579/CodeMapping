package com.tm.codemapping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tm.codemapping.bean.SettingBuildingBean;
import com.tm.codemapping.mapper.BasicSettingMapper;

@Service
public class BasicSettingService {

	@Autowired BasicSettingMapper basicSettingMapper;
	
	public List<SettingBuildingBean> getBuildingFloorAreaList(){
		
		return basicSettingMapper.getBuildingFloorAreaList();
	}
	
	@Transactional(readOnly=false)
	public SettingBuildingBean insertBuilding(String name) {
		SettingBuildingBean building = basicSettingMapper.insertBuilding(name);
		return building;
	}
	
	@Transactional(readOnly=false)
	public int deleteBuilding(String id) {	
		return	basicSettingMapper.deleteBuilding(id);			
	}	

	public int updateBuilding(SettingBuildingBean building) {
	   return basicSettingMapper.updateBuilding(building);		
	}
	
	public int insertFloor(String buildingId,String name) {
		return basicSettingMapper.insertFloor(buildingId, name);
	}
	
	public int updateFloor(String buildingId,String id,String name) {
		return basicSettingMapper.updateFloor(buildingId, id, name);
	}
}
