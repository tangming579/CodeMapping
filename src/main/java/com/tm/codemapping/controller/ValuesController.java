package com.tm.codemapping.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tm.codemapping.pojo.ReturnModel;


@RestController
@RequestMapping("/api/values")
public class ValuesController {

	@GetMapping
    public ReturnModel getAll() {
		
        	return new ReturnModel();
    }        
    
}
