package com.niu.sequence.service.impl;

import cn.hutool.core.lang.UUID;
import com.niu.sequence.service.UUIDSequenceService;
import org.springframework.stereotype.Service;

/**
 * @program: analysis-sequence
 * @description: UUID序列
 * @author: zhengzz
 * @create: 2019-12-31 14:10
 **/
@Service("UUIDSequenceServiceImpl")
public class UUIDSequenceServiceImpl implements UUIDSequenceService {

    @Override
    public String getSequence() {
        return UUID.randomUUID().toString();
    }
}
