package com.niu.interfaces.sequence.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @program: analysis-sequence
 * @description:
 * @author: zhengzz
 * @create: 2020-01-03 12:20
 **/
@FeignClient("analysis-niu-seqence-service")
public interface ServerService {
    @RequestMapping("server/info")
    String getInfo();
}
