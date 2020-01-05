package com.niu.sequence.controller;

import com.niu.interfaces.sequence.controller.BaseContoller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * @program: analysis-sequence
 * @description: 测试
 * @author: zhengzz
 * @create: 2020-01-03 11:27
 **/
@RestController
public class TestController extends BaseContoller {


    @RequestMapping("server/info")
    public String getServerInfo() {
        ServletRequestAttributes servletRequestAttribute= (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        String serveName=servletRequestAttribute.getRequest().getServerName();
        int port=servletRequestAttribute.getRequest().getLocalPort();

        return serveName+":"+port;
    }
}
