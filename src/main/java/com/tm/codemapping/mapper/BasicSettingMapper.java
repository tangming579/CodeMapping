package com.tm.codemapping.mapper;

import java.util.List;

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

	public List<SettingBuildingBean> getBuildingFloorAreaList();
	
	public SettingBuildingBean insertBuilding(@Param("name")String name);
	
	public int deleteBuilding(@Param("id")String id);
	
	public int updateBuilding(@Param(value="building")SettingBuildingBean building);	
	
	public int insertFloor(@Param("buildingId")String buildingId,@Param("name")String name);
	
	public int deleteFloor(@Param("floorId")String id);
	
	public int updateFloor(@Param("buildingId")String buildingId,@Param("id")String id,@Param("name")String name);
	
	public int insertArea(@Param("floorId")String floorId,@Param("name")String name);
	
	public int deleteArea(String id);
	
	public int updateArea(String id,String floorId,String name);
}
