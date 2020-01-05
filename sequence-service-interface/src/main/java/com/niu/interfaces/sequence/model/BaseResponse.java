package com.niu.interfaces.sequence.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: analysis-sequence
 * @description:
 * @author: zhengzz
 * @create: 2019-12-31 12:15
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel
public class BaseResponse<T> {
    @ApiModelProperty("响应码")
    private int code ;
    @ApiModelProperty("响应信息")
    private  String msg;
    @ApiModelProperty("响应结果")
    private T result;

}
