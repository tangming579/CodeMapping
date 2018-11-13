package com.tm.codemapping.service;

import java.util.Date;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.Scheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Service;

/**
* @author tangming
* @version 创建时间：2018年11月12日 下午8:07:22
* 类说明
*/
@Service
public class OrderQuartz extends QuartzJobBean {

	/** 
     * 要定时执行的内容
     */ 
    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
    	
        System.out.println("quartz task " + new Date());
    }
}