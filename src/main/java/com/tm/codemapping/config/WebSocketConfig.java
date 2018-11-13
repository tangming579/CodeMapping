package com.tm.codemapping.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
* @author tangming
* @version 创建时间：2018年11月13日 下午2:32:50
* 类说明
*/

@Configuration
public class WebSocketConfig {

	 @Bean  
	    public ServerEndpointExporter serverEndpointExporter() {  
	        return new ServerEndpointExporter();  
	    } 
}
