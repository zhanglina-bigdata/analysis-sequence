package com.niu.sequence.config;

import com.niu.sequence.Enum.SequenceEnum;
import com.niu.sequence.service.BaseSequence;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @program: analysis-sequence
 * @description: 序列化注册器
 * @author: zhengzz
 * @create: 2019-12-31 14:27
 **/
@Slf4j
public class SimpleSequenceRegister implements com.niu.sequence.config.SequenceRegister {

    private static  ConcurrentHashMap<String,Object> sequenceMap = new ConcurrentHashMap<>();

    public SimpleSequenceRegister() {
        sequenceMap.put(SequenceEnum.SNOW.name(),SequenceEnum.SNOW.getSequence());
        sequenceMap.put(SequenceEnum.UUID.name(),SequenceEnum.UUID.getSequence());
    }

    @Override
    public void registe(Class<?> clazz)  {
        try {
            if (clazz != null) {
                if (clazz.isAssignableFrom(BaseSequence.class)) {
                    sequenceMap.put(clazz.getName(), clazz.newInstance());
                }
            }
        }catch(IllegalAccessException| InstantiationException ex ) {
                log.error("can't instance this class");
        }
    }
}
