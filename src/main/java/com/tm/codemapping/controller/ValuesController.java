package com.tm.codemapping.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tm.codemapping.pojo.ReturnModel;

import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/api/values")
public class ValuesController {

	@GetMapping
	@ApiOperation(value="获取用户列表", notes="")
    public ReturnModel getAll() {
		
        	return new ReturnModel();
    }        
    
}
