package com.tm.codemapping.config;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import com.tm.codemapping.common.SpringJobFactory;
import com.tm.codemapping.service.OrderQuartz;

/**
* @author tangming
* @version 创建时间：2018年11月12日 下午7:57:06
* 类说明
*/
@Configuration
public class QuartzConfig {
    @Bean
    public JobDetail teatQuartzDetail(){
        return JobBuilder.newJob(OrderQuartz.class).withIdentity("testQuartz").storeDurably().build();
    }
    @Bean
    public Trigger testQuartzTrigger(){
        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
                .withIntervalInSeconds(10)  //设置时间周期单位秒
                .repeatForever();
        return TriggerBuilder.newTrigger().forJob(teatQuartzDetail())
                .withIdentity("testQuartz")
                .withSchedule(scheduleBuilder)
                .build();
    }
}
