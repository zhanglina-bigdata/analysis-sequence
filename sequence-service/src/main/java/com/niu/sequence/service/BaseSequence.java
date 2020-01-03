package com.niu.sequence.service;

import com.niu.sequence.Enum.DateJoinPointEnum;
import com.niu.sequence.annotation.JoinSequence;
import org.springframework.stereotype.Service;

@Service
public interface BaseSequence {

    public String getSequence() ;
}
