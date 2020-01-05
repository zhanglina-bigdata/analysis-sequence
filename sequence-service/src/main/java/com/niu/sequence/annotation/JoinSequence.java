package com.niu.sequence.annotation;

import com.niu.sequence.Enum.DateJoinPointEnum;

import java.lang.annotation.*;

@Documented
@Inherited
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface JoinSequence {
    String prefix() default  "";
    String preOvverride() default  "_";
    String suffix() default  "";
    String sufOverride() default "_";
    String dateformat() default "yyyyMMdd";
    DateJoinPointEnum joinpoint() default  DateJoinPointEnum.NONE;
}
