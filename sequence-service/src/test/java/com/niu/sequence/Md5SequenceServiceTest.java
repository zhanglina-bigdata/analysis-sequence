package com.niu.sequence;

import cn.hutool.core.lang.UUID;
import cn.hutool.crypto.digest.MD5;
import com.niu.sequence.service.Md5SequenceService;
import com.niu.sequence.service.SnowSequenceService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Random;
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class Md5SequenceServiceTest {
   @Autowired
   Md5SequenceService md5SequenceService;

    @Test
    public void testSnowSequence() throws Exception {
        log.info(md5SequenceService.getSequence(String.valueOf(Math.random())));
    }


}

