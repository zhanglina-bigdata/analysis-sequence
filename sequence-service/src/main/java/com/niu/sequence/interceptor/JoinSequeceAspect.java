package com.niu.sequence.interceptor;

import com.niu.sequence.annotation.JoinSequence;
import com.niu.sequence.model.request.SequenceRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @program: analysis-sequence
 * @description: 注解JoinSequence切面
 * @author: zhengzz
 * @create: 2020-01-02 14:48
 **/
@Component
@Aspect
// 允许Spring 自动选择代理模式
@EnableAspectJAutoProxy()
@Slf4j
public class JoinSequeceAspect {
    private static  final SimpleDateFormat sdf = new SimpleDateFormat();

    /***
    * @Description:定义连接点,标注有@JoinSequence的注解都会织入该连接点
    * @Param: []
    * @return:
    * @Author:
    * @Date: 2020/1/3
    */
    @Pointcut("@annotation(com.niu.sequence.annotation.JoinSequence)")
    private  void process() {

    }
    /***
    * @Description: 定义环绕增强
    * @Param: [joinPoint, joinSequence]
    * @return:
    * @Author:
    * @Date: 2020/1/3
    */
    @Around(value = "process() && @annotation(joinSequence)")
    public Object  AroundMethod(ProceedingJoinPoint joinPoint,JoinSequence joinSequence) throws Throwable {
        // 获取方法入参
        Object[] args= joinPoint.getArgs();
        SequenceRequest request=null;
        if(args.length!=0) {
            request = (SequenceRequest) args[0];
        }
        else {
            // 将注解转换为对象
            request= getSequence(joinSequence);
        }
        // 通过代理执行方法
       String sequence=(String)joinPoint.proceed();
        // 拼接序列
       return joinSequence(request,sequence);

    }
    /***
    * @Description: 将注解转换为请求对象
    * @Param: [joinSequence]
    * @return:
    * @Author:
    * @Date: 2020/1/3
    */
    public SequenceRequest getSequence(JoinSequence joinSequence) {
        SequenceRequest request = new SequenceRequest();
        request.setDateFormat(joinSequence.dateformat());
        request.setJoinPoint(new Integer(joinSequence.joinpoint().getPosition()).toString());
        request.setPrefix(joinSequence.prefix());
        request.setPreOvveride(joinSequence.preOvverride());
        request.setSuffix(joinSequence.suffix());
        request.setSufOvveride(joinSequence.preOvverride());

        return request;
    }

    /***
    * @Description:拼接sequence序列
    * @Param: [request]
    * @return:
    * @Author:
    * @Date: 2020/1/3
    */
    public String joinSequence(SequenceRequest request,String sequence) {
        String joinPoint = request.getJoinPoint();

        switch (joinPoint) {
            case "-1" :
                return joinSuxAndPref(request,sequence);
            default:
                sdf.applyPattern(request.getDateFormat());
                return joinSuxAndPref(request,sequence)+sdf.format(new Date());
        }
    }
    /***
    * @Description: 拼接前缀和后缀
    * @Param: [request]
    * @return:
    * @Author:
    * @Date: 2020/1/3
    */
    private  String joinSuxAndPref(SequenceRequest request,String sequence) {
        StringBuffer bf = new StringBuffer();
        if(!StringUtils.isEmpty(request.getPrefix())) {
            bf.append(request.getPrefix());
            bf.append(request.getPreOvveride());
            bf.append(sequence);
        }
        if(!StringUtils.isEmpty(request.getSuffix())) {
            bf.append(request.getSufOvveride());
            bf.append(request.getSuffix());
        }
        return bf.toString();
    }
}
