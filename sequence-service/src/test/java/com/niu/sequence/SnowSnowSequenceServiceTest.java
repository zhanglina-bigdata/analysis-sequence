package com.niu.sequence;
import com.niu.sequence.service.SnowSequenceService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @program: analysis-sequence
 * @description: 雪花序列服务测试
 * @author: zhengzz
 * @create: 2019-12-30 16:57
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class SnowSnowSequenceServiceTest {
    @Autowired
    SnowSequenceService snowSequenceService;
    @Test
    public  void testSnowSequence() throws Exception {
        log.info(snowSequenceService.getSequence());
    }


}
