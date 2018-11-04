package com.tm.codemapping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.tm.codemapping.service.BasicSettingService;

import io.swagger.annotations.Api;

@RestController
@Api(value = "基本信息操作")
public class BasicSettingController {

	 @Autowired BasicSettingService basicSettingService;
	 
	 
}
