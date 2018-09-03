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
import com.tm.codemapping.service.AssetItemService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/api/values")
@Api(value = "Swagger注解控制器")
public class ValuesController {

	@Autowired AssetItemService assetItemService;
	
	@GetMapping
	@ApiOperation(value="获取资产列表", notes="")
    public List<AssetItem> getAll() {
		
		List<AssetItem> items = assetItemService.getAll();		
		return items;
    }        
    
	@ApiOperation(value="获取特定资产", notes="")
	@ApiImplicitParam(name = "id", value = "资产ID",paramType = "path", dataType = "String")
	@RequestMapping(value = "/{id}", method=  {RequestMethod.POST,RequestMethod.GET})
    public AssetItem getOne(@PathVariable String id){
       
		AssetItem ts = assetItemService.getItemById(id);
        if(ts == null) {
            throw new ResourceNotFoundException();
        }
        return ts;
    }
	
	@ResponseBody
	@PostMapping("/updatePassword")
	@ApiOperation(value="创建特定资产", notes="")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "name", value = "资产名称", required = true,paramType="query", dataType = "String"),
		@ApiImplicitParam(name = "number", value = "资产编号", required = true,paramType="query", dataType = "String")
	})
	public AssetItem insertOne(@RequestParam(value="name",required=false) String name,@RequestParam(name="number",required=false) String number) {
		AssetItem item = assetItemService.insertItem(name, number);
		
		return item;
	}
}
