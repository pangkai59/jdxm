package com.jdxm.common.constant;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 返回给前端的状态码
 * 状态码取名约束如下:
 * 1. 状态码由6位数字组成
 * <p>
 * 2. - 100开头：认证类异常
 * - 500开头：业务类异常
 * - 600开头: 系统之间的异常
 * - 700开头: 交易异常
 * <p>
 * 3. 在这边添加完状态码之后,去doc/err_code.md中添加对应的说明
 */
@ApiModel(value = "StatusConstant", description = "状态码")
public class StatusConstant {

    @ApiModelProperty(value = "处理成功")
    public static final String SUCC = "1";

    @ApiModelProperty(value = "处理失败")
    public static final String ERR = "2";

    @ApiModelProperty(value = "用户未登录")
    public static final String ERR_UNLOGIN = "100001";

    @ApiModelProperty(value = "订单状态错误:订单审核中")
    public static final String ERR_ORDER_CHECKING = "500001";

    @ApiModelProperty(value = "没有银行卡信息")
    public static final String ERR_NO_BANKCARD = "500002";

    @ApiModelProperty(value = "签署合同异常")
    public static final String ERR_SIGN_CONTRACT = "500003";

    @ApiModelProperty(value = "分润系统异常")
    public static final String ERR_FENRUN = "600000";

    @ApiModelProperty(value = "代付请求异常")
    public static final String ERR_DAIFU = "700001";

}
