package com.niu.sequence.config;

/**
 * @program: analysis-sequence
 * @description:
 * @author: zhengzz
 * @create: 2019-12-31 14:42
 **/
public class SequenceContext {
    private SequenceRegister sequenceRegister;

    public SequenceContext() {
        sequenceRegister= new SimpleSequenceRegister();
    }

    public SequenceContext(SequenceRegister sequenceRegister) {
        if(sequenceRegister ==null) {
            new SequenceContext();
        }
        this.sequenceRegister = sequenceRegister;
    }

    public void setSequenceRegister(SequenceRegister sequenceRegister) {
        this.sequenceRegister = sequenceRegister;
    }
}
