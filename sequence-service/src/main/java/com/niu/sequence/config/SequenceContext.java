package com.niu.sequence.config;

/**
 * @program: analysis-sequence
 * @description:
 * @author: zhengzz
 * @create: 2019-12-31 14:42
 **/
public class SequenceContext {
    private com.niu.sequence.config.SequenceRegister sequenceRegister;

    public SequenceContext() {
        sequenceRegister= new com.niu.sequence.config.SimpleSequenceRegister();
    }

    public SequenceContext(com.niu.sequence.config.SequenceRegister sequenceRegister) {
        if(sequenceRegister ==null) {
            new SequenceContext();
        }
        this.sequenceRegister = sequenceRegister;
    }

    public void setSequenceRegister(com.niu.sequence.config.SequenceRegister sequenceRegister) {
        this.sequenceRegister = sequenceRegister;
    }
}
