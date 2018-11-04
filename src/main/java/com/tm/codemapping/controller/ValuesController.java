package com.tm.codemapping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tm.codemapping.bean.AssetItem;
import com.tm.codemapping.bean.ResultBean;
import com.tm.codemapping.common.ResultEnum;
import com.tm.codemapping.execption.ResultException;
import com.tm.codemapping.service.AssetItemService;
import com.tm.codemapping.utils.ResultUtils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/api/values")
@Api(value = "资产相关操作")
public class ValuesController {

	@Autowired AssetItemService assetItemService;
	
	@SuppressWarnings("unchecked")
	@GetMapping
	@ApiOperation(value="获取资产列表", notes="")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "start", value = "页数", required = true,paramType="query", dataType = "int"),
		@ApiImplicitParam(name = "limit", value = "页长", required = true,paramType="query", dataType = "int")
	})
    public ResultBean<List<AssetItem>> getAll(int start,int limit) throws Exception{
		
		if(start<0)
			throw new ResultException(ResultEnum.LIMIT_ERROR);
		List<AssetItem> items = assetItemService.getAll(start,limit);		
		return ResultUtils.success(items);
    }        
    
	@ApiOperation(value="获取特定资产", notes="")
	@ApiImplicitParam(name = "id", value = "资产ID",paramType = "path", dataType = "String")
	@RequestMapping(value = "/{id}", method=  {RequestMethod.POST,RequestMethod.GET})
    public AssetItem getOne(@PathVariable String id) throws Exception{
       
		AssetItem ts = assetItemService.getItemById(id);
        if(ts == null) {
            throw new ResultException(ResultEnum.IDNOTFOUND_ERROR);
        }
        return ts;
    }
	
	@PostMapping("/insertOne")
	@ApiOperation(value="创建特定资产", notes="")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "name", value = "资产名称", required = true,paramType="query", dataType = "String"),
		@ApiImplicitParam(name = "number", value = "资产编号", required = true,paramType="query", dataType = "String")
	})
	public AssetItem insertOne(@RequestParam(value="name",required=false) String name,@RequestParam(name="number",required=false) String number) {
		AssetItem item = assetItemService.insertItem(name, number);
		
		return item;
	}
	
	@PostMapping("/UpdateOne")
	@ApiOperation(value="更新特定资产", notes="")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "id", value = "资产id", required = true,paramType="query", dataType = "String"),
		@ApiImplicitParam(name = "name", value = "资产名称", required = true,paramType="query", dataType = "String"),
		@ApiImplicitParam(name = "number", value = "资产编号", required = false,paramType="query", dataType = "String")
	})
	public AssetItem updateOne(@RequestParam(value="id",required=true) String id,@RequestParam(value="name",required=false) String name,@RequestParam(name="number",required=false) String number) {
		AssetItem ts = assetItemService.getItemById(id);
        if(ts == null) {
            throw new ResourceNotFoundException();
        }
        AssetItem item = assetItemService.updateItem(ts);
		return item;
	}
}
