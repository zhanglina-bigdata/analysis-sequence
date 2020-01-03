package com.niu.sequence.controller;

import com.niu.sequence.model.BaseResponse;
import com.niu.sequence.service.SnowSequenceService;
import com.niu.sequence.service.UUIDSequenceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * @program: analysis-sequence
 * @description: 雪花序列服务
 * @author: zhengzz
 * @create: 2019-12-31 12:00
 **/
@RestController
@RequestMapping(value =BaseContoller.APP_NAME_PREFIX+"/"+BaseContoller.VERSION+"/sequence",produces = MediaType.APPLICATION_JSON_VALUE )
@Slf4j
@Api(value = "SequenceController")
public class SequenceController {
    @Autowired
    private SnowSequenceService snowSequenceService;

   // @Qualifier("UUIDSequenceService")
    @Autowired
    private UUIDSequenceService uuidSequenceService;

    @ApiOperation(value = "获取雪花序列",response = BaseResponse.class)
    @RequestMapping("/snow")
    public BaseResponse<Object> getSequence() {

        log.info(snowSequenceService==null?"":"false");
        String sequence = snowSequenceService.getSequence();
            if(StringUtils.isEmpty(sequence)) {
                return BaseResponse.builder().code(HttpStatus.BAD_REQUEST.value()).msg("序列号不存在").result(null).build();
            }
        return BaseResponse.builder().code(HttpStatus.OK.value()).msg("success").result(sequence).build();
    }

    @ApiOperation(value = "获取雪花序列",response = BaseResponse.class)
    @RequestMapping("/uuid")
    public BaseResponse<Object> getUUID() {
        String sequence = uuidSequenceService.getSequence();
        if(StringUtils.isEmpty(sequence)) {
            return BaseResponse.builder().code(HttpStatus.BAD_REQUEST.value()).msg("序列号不存在").result(null).build();
        }
        return BaseResponse.builder().code(HttpStatus.OK.value()).msg("success").result(sequence).build();
    }
    @RequestMapping("/error")
    public BaseResponse<Object> geterror() throws Exception {

      throw new Exception();
    }
}
