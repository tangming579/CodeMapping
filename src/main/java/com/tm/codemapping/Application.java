package com.tm.codemapping;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

import com.tm.codemapping.netty.NettyServer;

@SpringBootApplication
@ServletComponentScan //配置druid必须加的注解，如果不加，访问页面打不开
@MapperScan({"com.tm.codemapping.mapper","com.tm.system.mapper"})
@PropertySource(value= "classpath:/application.yml")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
