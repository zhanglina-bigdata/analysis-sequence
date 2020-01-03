package com.niu.sequence.Enum;

/**
 * 定义日期插入的连接点
 */
public enum DateJoinPointEnum {
    /**
     * 不插入
     */
    NONE(-1),
    /**
     * 在前缀之前插入
     */
    PREFIX_FIRST(0),
    /**
     * 在前缀之后插入
     */
    PREFIX_LAST(1),
    /**
     * 覆盖前缀
     */
    NO_PREFIX(2),
    /**
     * 在后缀之前插入
     */
    SUFFIX_FIRST(3),
    /**
     * 在后缀之后插入
     */
    SUFFIX_LAST(4),
    /**
     * 覆盖后缀
     */
    NO_SUFFIX(5);


    private   int position;

    DateJoinPointEnum(int position) {
        this.position = position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }
}
