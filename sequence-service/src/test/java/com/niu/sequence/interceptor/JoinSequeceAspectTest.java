package com.niu.sequence.interceptor;

import com.niu.sequence.service.impl.SnowSnowSequenceServiceImpl;
import org.junit.Test;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;

/**
 * @program: analysis-sequence
 * @description: JoinSequence Annotation Aspect切面测试
 * @author: zhengzz
 * @create: 2020-01-02 15:03
 **/
public class JoinSequeceAspectTest {
    @Test
    public void testSequenceAspect() {
        SnowSnowSequenceServiceImpl service = new SnowSnowSequenceServiceImpl();
        AspectJProxyFactory factory = new AspectJProxyFactory();
        factory.setTarget(service);
        factory.addAspect(JoinSequeceAspect.class);
        factory.addAspect(CostTimeAspect.class);
        SnowSnowSequenceServiceImpl proxy=factory.getProxy();
        proxy.getSequence();
    }
}
