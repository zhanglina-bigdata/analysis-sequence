package com.niu.sequence.service;

import org.springframework.stereotype.Service;

@Service
public interface Md5SequenceService extends BaseSequence {
    public String getSequence(String data);

}
