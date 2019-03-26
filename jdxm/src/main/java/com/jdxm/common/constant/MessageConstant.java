package com.jdxm.common.constant;

/**
 * Created by lx.xu on 2018/6/6.
 */
public class MessageConstant {
    //短信模板配置
    public static final String OPERATOR_SEGMENT = "OPERATOR_SEGMENT"; // 获取手机合法性校验的正则表达式
    public static final String SMS_SIGN = "SMS_SIGN"; // 短信签名
    public static final String SMS_SIGN_POS = "SMS_SIGN_POS"; // 短信签名位置 prefix:前缀 suffix:后缀
    public static final String SMS_REPAY_RE = "SMS_REPAY_RE"; // 还款提醒 提前提醒天数
    public static final String SMS_REPAY_TIME = "SMS_REPAY_TIME"; // 还款提醒 消息发送时间
    public static final String SMS_OVER_TIME = "SMS_OVER_TIME"; // 逾期通知 消息发送时间
    public static final String SMS_OVER_INTERVEL = "SMS_OVER_INTERVEL"; // 逾期通知 消息发送间隔 / 小时
    public static final String SMS_OVER_FRE = "SMS_OVER_FRE"; // 逾期通知 消息发送频次  次/天
    public static final String SMS_OVER_SEND_NUM = "SMS_OVER_SEND_NUM"; // 逾期通知 消息发送的天数
    public static final String SMS_DAIBAN_INTERVEL = "SMS_DAIBAN_INTERVEL"; // 待办提醒 消息发送时间间隔
    public static final String SMS_DAIBAN_TIME_MIN = "SMS_DAIBAN_TIME_MIN"; // 待办提醒 时间范围最小值
    public static final String SMS_DAIBAN_TIME_MAX = "SMS_DAIBAN_TIME_MAX"; // 待办提醒 时间范围最大值
    public static final String SMS_DAIBAN_SEND_NUM = "SMS_DAIBAN_SEND_NUM"; // 待办提醒 发送总次数

    public static final String SMS_TPL_REG = "SMS_TPL_REG"; // 短信模板 注册验证码
    public static final String SMS_TPL_LOGINSMS = "SMS_TPL_LOGINSMS"; // 短信模板 手机验证码登录
    public static final String SMS_TPL_EDIT_MOBILE = "SMS_TPL_EDIT_MOBILE"; // 短信模板 修改手机
    public static final String SMS_TPL_ACTIVITY = "SMS_TPL_ACTIVITY"; //短信模版 营销活动
    public static final String SMS_TPL_RISK_CHECK_PASS_MODE = "SMS_TPL_RISK_CHECK_PASS_MODE"; // 短信 风控审核通过
    public static final String SMS_TPL_RISK_CHECK_REJECT = "SMS_TPL_RISK_CHECK_REJECT"; // 短信模板 风控审核不通过
    public static final String SMS_TPL_ORDER_ADD = "SMS_TPL_ORDER_ADD"; // 短信模板 订单生成（征信查询通过后）
    public static final String SMS_TPL_DATA_PERFECT = "SMS_TPL_DATA_PERFECT"; // 资料完善
    public static final String SMS_TPL_CHANGE_CAR = "SMS_TPL_CHANGE_CAR"; // 换车型，换购车方案
    public static final String SMS_TPL_UNDER_PAY_REJECT = "SMS_TPL_UNDER_PAY_REJECT"; // 线下支付财务审核不通过
    public static final String SMS_TPL_CONTRACT_PASS = "SMS_TPL_CONTRACT_PASS"; // 签约完成，提醒支付首付
    public static final String SMS_TPL_PAY_WAIT_CAR = "SMS_TPL_PAY_WAIT_CAR"; // 支付首付完成，等待提车
    public static final String SMS_TPL_LIFT_CAR = "SMS_TPL_LIFT_CAR"; // 提醒提车
    public static final String SMS_TPL_AUTO_RENT = "SMS_TPL_AUTO_RENT"; // 还租日T-X日（自动扣款）
    public static final String SMS_TPL_MANUAL_RENT = "SMS_TPL_MANUAL_RENT"; // 还租日T-X日（手动支付，或线下支付）
    public static final String SMS_TPL_OVERDUE_RENT = "SMS_TPL_OVERDUE_RENT"; // 逾期交租
    public static final String SMS_TPL_REPAY_OVERDUE = "SMS_TPL_REPAY_OVERDUE"; // 短信模板 逾期提醒
    public static final String SMS_TPL_BRAR_DEAL = "SMS_TPL_BRAR_DEAL"; // 违章处理
    public static final String SMS_TPL_INSURANCE_INDE = "SMS_TPL_INSURANCE_INDE"; // 保险理赔
    public static final String SMS_TPL_LAST_XUZU = "SMS_TPL_LAST_XUZU"; // 最后一期租金还款提醒时加入到期处置续租，尾款购车，退车或分期购车
    public static final String SMS_TPL_ORDER_NO_DEAL = "SMS_TPL_ORDER_NO_DEAL"; // 预约订单未处理
    public static final String SMS_TPL_ATT_UP_FAIL = "SMS_TPL_ATT_UP_FAIL"; // 影像资料上传不成功
    public static final String SMS_TPL_ORDER_NO_SUBMIT_CHECK = "SMS_TPL_ORDER_NO_SUBMIT_CHECK"; // 订单未提交审批
    public static final String SMS_TPL_CHECK_REJECT = "SMS_TPL_CHECK_REJECT"; // 审批不通过
    public static final String SMS_TPL_RISK_CHECK_PASS = "SMS_TPL_RISK_CHECK_PASS"; //  风控审核通过
    public static final String SMS_TPL_CUSTOM_LIFT_CAR = "SMS_TPL_CUSTOM_LIFT_CAR"; // 提醒客户提车
    public static final String SMS_TPL_DATA_WAIT_CHECK = "SMS_TPL_DATA_WAIT_CHECK"; // 客户资料上传，等待审批
    public static final String SMS_TPL_RECE_CONFIRM = "SMS_TPL_RECE_CONFIRM"; // 首付、租金收款
    public static final String SMS_TPL_LOAN = "SMS_TPL_LOAN"; // 放款
    public static final String SMS_TPL_CHECK = "SMS_TPL_CHECK"; // 审批
    public static final String SMS_TPL_RESET_LOGIN_PWD = "SMS_TPL_RESET_LOGIN_PWD"; // 短信模板 重置登录密码
    public static final String SMS_TPL_FORGET_PWD = "SMS_TPL_FORGET_PWD"; // 短信模板 忘记密码
    public static final String SMS_TPL_ADD_BANK = "SMS_TPL_ADD_BANK"; // 绑定银行卡


    //-------------------------------------此处暂时不用-----------------------------------------------------------------
    public static final String SMS_TPL_REPAY_OVERDUE_MODE = "SMS_TPL_REPAY_OVERDUE_MODE"; // 短信 逾期提醒 发送哪些渠道
    public static final String SMS_TPL_REG_SUCC = "SMS_TPL_REG_SUCC"; // 短信模板 注册成功
    public static final String SMS_TPL_REG_SUCC_MODE = "SMS_TPL_REG_SUCC_MODE"; // 短信 注册成功后  发送哪些渠道
    public static final String SMS_TPL_RISK_CHECK_REJECT_MODE = "SMS_TPL_RISK_CHECK_REJECT_MODE"; // 短信 风控审核不通过 发送哪些渠道
    public static final String SMS_TPL_LOAN_CHECK_PASS = "SMS_TPL_LOAN_CHECK_PASS"; // 短信模板 放款审核通过
    public static final String SMS_TPL_LOAN_CHECK_PASS_MODE = "SMS_TPL_LOAN_CHECK_PASS_MODE"; // 短信 放款审核通过 发送哪些渠道
    public static final String SMS_TPL_LOAN_CHECK_REJECT = "SMS_TPL_LOAN_CHECK_REJECT"; // 短信模板 放款审核不通过
    public static final String SMS_TPL_LOAN_CHECK_REJECT_MODE = "SMS_TPL_LOAN_CHECK_REJECT_MODE"; // 短信 放款审核不通过 发送哪些渠道
    public static final String SMS_TPL_REPAY_PRE_NOTICE = "SMS_TPL_REPAY_PRE_NOTICE"; // 短信模板 还款日之前的提醒
    public static final String SMS_TPL_REPAY_PRE_NOTICE_MODE = "SMS_TPL_REPAY_PRE_NOTICE_MODE"; // 短信 还款日之前的提醒 发送哪些渠道
    public static final String SMS_TPL_REPAY_SUCC = "SMS_TPL_REPAY_SUCC"; // 短信模板 还款成功
    public static final String SMS_TPL_REPAY_SUCC_MODE = "SMS_TPL_REPAY_SUCC_MODE"; // 短信 还款成功 发送哪些渠道
    public static final String SMS_TPL_REPAY_DK_FAIL = "SMS_TPL_REPAY_DK_FAIL"; // 短信模板 代扣失败
    public static final String SMS_TPL_REPAY_DK_FAIL_MODE = "SMS_TPL_REPAY_DK_FAIL_MODE"; // 短信 代扣失败 发送哪些渠道
    public static final String SMS_TPL_REPAY_OVERDUE_PAID = "SMS_TPL_REPAY_OVERDUE_PAID"; // 短信模板 逾期还款提醒
    public static final String SMS_TPL_REPAY_OVERDUE_PAID_MODE = "SMS_TPL_REPAY_OVERDUE_PAID_MODE"; // 短信 逾期还款提醒 发送哪些渠道
    public static final String SMS_TPL_REQ_EDIT_MOBILE = "SMS_TPL_REQ_EDIT_MOBILE"; // 短信模板 修改手机前校验

    //------------------------------------------------------------------------------------------------------------------

}
