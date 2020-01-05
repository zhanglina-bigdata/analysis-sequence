package com.niu.interfaces.sequence.controller;


import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: analysis-sequence
 * @description:
 * @author: zhengzz
 * @create: 2019-12-31 12:03
 **/
@RestController
@Api(value = "BaseContoller")
public class BaseContoller {
    public final static  String APP_NAME_PREFIX="niu";
    public final static String VERSION="v1";

    public static  String getApp(){
        return  APP_NAME_PREFIX+"/"+VERSION;
    }



}
