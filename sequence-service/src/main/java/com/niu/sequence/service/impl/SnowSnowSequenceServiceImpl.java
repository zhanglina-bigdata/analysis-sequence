package com.niu.sequence.service.impl;

import cn.hutool.core.lang.Snowflake;
import com.niu.sequence.service.SnowSequenceService;
import com.niu.sequence.annotation.CostTime;
import org.springframework.stereotype.Service;

/**
 * @program: analysis-sequence
 * @description: 雪花序列
 * @author: zhengzz
 * @create: 2019-12-30 16:46
 **/
@Service
public class SnowSnowSequenceServiceImpl implements SnowSequenceService {
    @Override
    @CostTime
    public String getSequence()  {
        return new Snowflake(0,0).nextIdStr();
    }
}
