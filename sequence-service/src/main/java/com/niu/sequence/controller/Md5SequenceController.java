package com.niu.sequence.controller;

import com.niu.interfaces.sequence.controller.BaseContoller;
import com.niu.interfaces.sequence.model.BaseResponse;
import com.niu.sequence.service.Md5SequenceService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping(value = BaseContoller.APP_NAME_PREFIX + "/" + BaseContoller.VERSION + "/sequence", produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
public class Md5SequenceController {
        @Autowired
        private Md5SequenceService md5SequenceService;
        @ApiOperation(value = "获取md5序列", response = BaseResponse.class)
        @RequestMapping("/md5")
        public BaseResponse<Object> getSequence() {
            log.info(md5SequenceService == null ? "" : "false");
            String sequence = md5SequenceService.getSequence((String.valueOf(Math.random())));
            if (StringUtils.isEmpty(sequence)) {
                return BaseResponse.builder().code(HttpStatus.BAD_REQUEST.value()).msg("序列号不存在").result(null).build();
            }
            return BaseResponse.builder().code(HttpStatus.OK.value()).msg("success").result(sequence).build();
        }
    }

