package com.niu.sequence.interceptor;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @program: analysis-sequence
 * @description: 方法执行耗时切面
 * @author: zhengzz
 * @create: 2020-01-02 15:06
 **/
@Component
@Aspect
@Slf4j
@ToString
@ApiModel
public class CostTimeAspect {

    @ApiModelProperty("方法名")
    private String methodName;
    @ApiModelProperty("起始时间")
    private long startTime;
    @ApiModelProperty("结束时间")
    private long endTime;
    @ApiModelProperty("起始日期")
    private String startDate;
    @ApiModelProperty("结束日期")
    private String endDate;
    @ApiModelProperty("花费时间/毫秒")
    private long costMill;
    @ApiModelProperty("时间格式化")
    private static  final ThreadLocal<DateFormat> format=new ThreadLocal();

    @Before("@annotation(com.niu.sequence.annotation.CostTime)")
    public void entryMethod(JoinPoint joinPoint) {
      this.methodName=joinPoint.toString();
       this.startTime=System.currentTimeMillis();
    }
    @After("@annotation(com.niu.sequence.annotation.CostTime)")
    public void leaveMethod(){
        format.set(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS"));
        this.endTime=System.currentTimeMillis();
        Date date = new Date();
        date.setTime(startTime);
        startDate= format.get().format(date);
        date.setTime(endTime);
        endDate=format.get().format(date);
        costMill=endTime-startTime;
        log.info(this.toString());
        format.remove();
    }
}
