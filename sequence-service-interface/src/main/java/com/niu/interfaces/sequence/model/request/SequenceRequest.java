package com.niu.interfaces.sequence.model.request;

import com.niu.interfaces.sequence.model.BaseRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: analysis-sequence
 * @description: 序列化请求
 * @author: zhengzz
 * @create: 2020-01-02 14:20
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel
public class SequenceRequest extends BaseRequest {
    @ApiModelProperty("前缀名")
    private  String prefix;
    @ApiModelProperty("前缀连接符")
    private String preOvveride;
    @ApiModelProperty("后缀名")
    private String suffix;
    @ApiModelProperty("后缀符")
    private String sufOvveride;
    @ApiModelProperty("日期格式")
    private String dateFormat;
    @ApiModelProperty("日期连接点")
    private  String joinPoint;
}
