package com.niu.interfaces.sequence.service;

import com.niu.interfaces.sequence.controller.BaseContoller;
import com.niu.interfaces.sequence.model.BaseResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @program: analysis-sequence
 * @description: 邮件服务
 * @author: zhengzz
 * @create: 2020-01-03 15:01
 **/
@FeignClient("analysis-niu-seqence-service")
public interface EmailSequenceService {
    @RequestMapping(BaseContoller.APP_NAME_PREFIX+"/"+BaseContoller.VERSION+"/sequence/email")
    BaseResponse<String> getSeuqence();
}