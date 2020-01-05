package com.niu.sequence.service;

import com.niu.interfaces.sequence.model.request.SequenceRequest;
import org.springframework.stereotype.Service;

@Service
public interface EmailSequenceService extends com.niu.sequence.service.BaseSequence {
    public String getSequence(SequenceRequest request);
}
