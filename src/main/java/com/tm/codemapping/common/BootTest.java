package com.tm.codemapping.common;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

/**
* @author tangming
* @version 创建时间：2018年11月15日 下午8:20:16
* 类说明
*/
@Component
public class BootTest {

	@PostConstruct
    public void init() {
        System.out.println("Creating Boss.11111");
    }
}
