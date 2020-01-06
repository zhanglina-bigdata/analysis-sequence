package com.niu.sequence.service.impl;

import cn.hutool.crypto.digest.MD5;
import com.niu.sequence.annotation.CostTime;
import com.niu.sequence.service.Md5SequenceService;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * md5生成随机系列
 */
@Service
public class Md5SequenceServiceImpl implements Md5SequenceService {
    @Override
    @CostTime
    public String getSequence() {
      return  null;
    }

    @Override
    @CostTime
    public String getSequence(String data) {
            String s = String.valueOf(System.currentTimeMillis() + new Random().nextInt());
            return new MD5(s.getBytes(), 1, '1').digestHex(data);
        }

}
