package com.niu.sequence.service.impl;

import com.niu.sequence.Enum.DateJoinPointEnum;
import com.niu.sequence.annotation.JoinSequence;
import com.niu.sequence.model.request.SequenceRequest;
import com.niu.sequence.service.EmailSequenceService;
import com.niu.sequence.service.SnowSequenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: analysis-sequence
 * @description: 邮件序列服务
 * @author: zhengzz
 * @create: 2020-01-02 15:53
 **/
@Service
public class EmailSequeceServiceImpl implements EmailSequenceService {

    @Autowired
    private SnowSequenceService snowSequenceService;
    @Override
    @JoinSequence(prefix = "emil", preOvverride = "_" ,joinpoint = DateJoinPointEnum.SUFFIX_LAST)
    public String getSequence() {
        return snowSequenceService.getSequence();
    }

    @Override
    @JoinSequence()
    public String getSequence(SequenceRequest request) {
        return snowSequenceService.getSequence();
    }
}
