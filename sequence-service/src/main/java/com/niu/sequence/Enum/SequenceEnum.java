package com.niu.sequence.Enum;

import com.niu.sequence.service.BaseSequence;
import com.niu.sequence.service.impl.SnowSnowSequenceServiceImpl;
import com.niu.sequence.service.impl.UUIDSequenceServiceImpl;

/**
 * @program: analysis-sequence
 * @description: 序列化服务枚举类
 * @author: zhengzz
 * @create: 2019-12-31 14:38
 **/
public enum  SequenceEnum {
    SNOW("snow",new SnowSnowSequenceServiceImpl()),
    UUID("uuid",new UUIDSequenceServiceImpl());

    private String name;
    private BaseSequence sequence;

    SequenceEnum(String name, BaseSequence sequence) {
        this.name = name;
        this.sequence = sequence;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BaseSequence getSequence() {
        return sequence;
    }

    public void setSequence(BaseSequence sequence) {
        this.sequence = sequence;
    }
}
