package com.tm.codemapping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tm.codemapping.bean.ResultBean;
import com.tm.codemapping.bean.SettingBuildingBean;
import com.tm.codemapping.common.ResultEnum;
import com.tm.codemapping.execption.ResultException;
import com.tm.codemapping.service.BasicSettingService;
import com.tm.codemapping.utils.ResultUtils;
import com.tm.codemapping.utils.StringUtils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/api/basicsetting")
@Api(tags = "基本信息操作")
public class BasicSettingController {

	 @Autowired BasicSettingService basicSettingService;
	 
	 
	 @ApiOperation(value="获取建筑、楼层、区域集合", notes="")
	 @RequestMapping(value="getBuildingFloorAreaList",method= RequestMethod.POST)
	 public ResultBean getBuildingFloorAreaList() throws Exception {		 
		 List<SettingBuildingBean> result = basicSettingService.getBuildingFloorAreaList();
		 return ResultUtils.success(result);
	 }
	 
	 @ApiOperation(value="新建建筑", notes="")
	 @ApiImplicitParam(name = "name", value = "建筑名称",paramType = "query", dataType = "String")
	 @RequestMapping(value="insertBuilding",method= RequestMethod.POST)
	 public ResultBean insertBuilding(String name) throws Exception {
		 if(StringUtils.isNullOrWhiteSpace(name)) {
			 throw new ResultException(ResultEnum.NOTNULL_ERROR);
		 }
		 basicSettingService.insertBuilding(name);
		 return ResultUtils.success();
	 }
	 
	 @ApiOperation(value="删除建筑", notes="")
	 @ApiImplicitParam(name = "id", value = "建筑id",paramType = "query", dataType = "String")
	 @RequestMapping(value="deleteBuilding",method= RequestMethod.POST)
	 public ResultBean deleteBuilding(String id) throws Exception {
		 if(StringUtils.isNullOrWhiteSpace(id)) {
			 throw new ResultException(ResultEnum.NOTNULL_ERROR);
		 }
		 basicSettingService.deleteBuilding(id);
		 return ResultUtils.success();
	 }
	 
	 @ApiOperation("更新建筑")
	 @PostMapping("/updateBuilding")
	 public ResultBean updateBuilding(@RequestBody @ApiParam(name="建筑对象",value="传入json格式",required=true) SettingBuildingBean building) throws Exception {
		 //building=new SettingBuildingBean();
		 //building.setName("ccc");
		 //building.setId("47070245-e03b-11e8-a73b-b888e3f23ef9");
		 Integer result = basicSettingService.updateBuilding(building);
		 if(result == 1) {
			 return ResultUtils.success();
		 }		 
		 else {
			 throw new ResultException(ResultEnum.IDNOTFOUND_ERROR);
		 }
	 }
	 @ApiOperation(value="新建楼层", notes="")
	 @ApiImplicitParam(name = "id", value = "楼层id",paramType = "query", dataType = "String")
	 @RequestMapping(value="insertFloor",method= RequestMethod.POST)
	 public ResultBean insertFloor(String buildingId,String name) throws Exception {
		 if(StringUtils.isNullOrWhiteSpace(buildingId)) {
			 throw new ResultException(ResultEnum.NOTNULL_ERROR);
		 }
		 basicSettingService.insertFloor(buildingId,name);
		 return ResultUtils.success();
	 }
	 @ApiOperation(value="更新楼层", notes="")
	 @ApiImplicitParam(name = "id", value = "楼层id",paramType = "query", dataType = "String")
	 @RequestMapping(value="updateFloor",method= RequestMethod.POST)
	 public ResultBean updateFloor(String buildingId,String id,String name) throws Exception {
		 if(StringUtils.isNullOrWhiteSpace(buildingId)||StringUtils.isNullOrWhiteSpace(id)) {
			 throw new ResultException(ResultEnum.NOTNULL_ERROR);
		 }
		 basicSettingService.updateFloor(buildingId,id,name);
		 return ResultUtils.success();
	 }
}
