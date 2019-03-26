package com.jdxm.common.constant;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "返回状态")
public class RTConstant {

    @ApiModelProperty(value = "状态码")
    public String code;

    @ApiModelProperty(value = "返回描述信息")
    public String message;


    public RTConstant(){
        this.code = StatusConstant.SUCC;
        this.message = "OK";
    }

    public RTConstant(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
