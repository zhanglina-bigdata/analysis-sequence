package com.niu.sequence.service;

import com.niu.sequence.model.request.SequenceRequest;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @program: analysis-sequence
 * @description: 邮件序列服务测试
 * @author: zhengzz
 * @create: 2020-01-02 16:06
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class EmailSequeceServiceTest {
    @Autowired
    private EmailSequenceService sequenceService;

    @Test
    public void testGetEmilSequence(){
        log.info(sequenceService.getSequence());
    }

    @Test
    public void testGetEmilSequenceByRequest(){
        SequenceRequest sequenceRequest = new SequenceRequest();
        sequenceRequest.setPrefix("Email-NIU");
        sequenceRequest.setPreOvveride("-");
        sequenceRequest.setDateFormat("yyyy-MM-dd");
        sequenceRequest.setJoinPoint("4");
        log.info(sequenceService.getSequence(sequenceRequest));
    }

}
