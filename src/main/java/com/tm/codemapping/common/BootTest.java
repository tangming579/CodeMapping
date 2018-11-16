package com.tm.codemapping.common;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
* @author tangming
* @version 创建时间：2018年11月15日 下午8:20:16
* 类说明
*/
@Component
public class BootTest {

	private static Logger logger = LoggerFactory.getLogger(BootTest.class);
	
	@PostConstruct
    public void init() {
		
		logger.info("Creating Boss.11111");
    }
}
