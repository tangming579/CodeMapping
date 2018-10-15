package com.tm.codemapping.config;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.pool.DruidDataSource;

/**
 * 配置druid需要的配置类，引入application.properties文件中以spring.datasource开头的信息
 * 因此需要在application.properties文件中配置相关信息。
 * @author Administrator
 *
 */
@Configuration
public class DruidConfig {
	@Bean  
    @ConfigurationProperties(prefix = "spring.datasource")  
    public DataSource druidDataSource() {  
        DruidDataSource druidDataSource = new DruidDataSource();  
        return druidDataSource;  
    } 
}
