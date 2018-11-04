package com.tm.codemapping.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.tm.codemapping.bean.SettingAreaBean;
import com.tm.codemapping.bean.SettingBuildingBean;
import com.tm.codemapping.bean.SettingFloorBean;

@Repository
@Mapper
public interface BasicSettingMapper {

	public int getBuildingFloorAreaList();
	
	@Select("insert into asset_building (id,name,vaild) values(uuid(),#{name},1)")
	public SettingBuildingBean insertBuilding(@Param("name")String name);
	
	public int deleteBuilding(SettingBuildingBean building);
	
	public int updateBuilding(SettingBuildingBean building);
	
	public SettingFloorBean insertFloor(String buildingId,String name);
	
	public int deleteFloor(String id);
	
	public int updateFloor(String buildingId,String id,String name);
	
	public SettingAreaBean insertArea(String floorId,String name);
	
	public int deleteArea(String id);
	
	public int updateArea(String floorId,String name);
}
