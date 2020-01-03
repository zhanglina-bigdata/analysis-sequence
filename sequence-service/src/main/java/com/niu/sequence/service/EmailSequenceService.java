package com.niu.sequence.service;

import com.niu.sequence.model.request.SequenceRequest;
import org.springframework.stereotype.Service;

@Service
public interface EmailSequenceService extends  BaseSequence {
    public String getSequence(SequenceRequest request);
}
