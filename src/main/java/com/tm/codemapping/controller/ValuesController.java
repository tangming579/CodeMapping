package com.tm.codemapping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tm.codemapping.pojo.AssetItemPojo;
import com.tm.codemapping.service.AssetItemService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/api/values")
public class ValuesController {

	@Autowired AssetItemService assetItemService;
	
	@GetMapping
	@ApiOperation(value="获取资产列表", notes="")
    public List<AssetItemPojo> getAll() {
		
		List<AssetItemPojo> items = assetItemService.getAll();		
		return items;
    }        
    
	@ApiOperation(value="获取特定资产", notes="")
	@ApiImplicitParam(name = "id", value = "资产ID", required = true, dataType = "String")
	@GetMapping("/{id}")
    public AssetItemPojo getOne(@PathVariable String id){
       
		AssetItemPojo ts = assetItemService.getItemById(id);
        if(ts == null) {
            throw new ResourceNotFoundException();
        }
        return ts;
    }
}
