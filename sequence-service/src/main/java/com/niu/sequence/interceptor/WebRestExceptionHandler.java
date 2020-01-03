package com.niu.sequence.interceptor;

import com.niu.sequence.model.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @program: analysis-sequence
 * @description: web全局异常拦截处理器
 * @author: zhengzz
 * @create: 2019-12-31 13:53
 **/
@RestControllerAdvice
@Slf4j
public class WebRestExceptionHandler {
    /**
     * 拦截所有运行时的全局异常   
     */
    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public BaseResponse runtimeException(RuntimeException e) {
        log.error(e.getMessage(), e);
        // 返回 JOSN
        BaseResponse<String> error= BaseResponse.<String>builder().code(HttpStatus.INTERNAL_SERVER_ERROR.value()).build();
        return error;
    }

    /**
     * 系统异常捕获处理
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public BaseResponse exception(Exception e) {
        log.error(e.getMessage(), e);
        // 返回 JOSN
        BaseResponse<String> error= BaseResponse.<String>builder().code(HttpStatus.INTERNAL_SERVER_ERROR.value()).msg("服务器内部错误").build();
        return error;
    }
}
