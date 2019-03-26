package com.jdxm.common.constant;

/**
 * 通用常量类(如果可细分，可以抽取出来单独建文件)
 */
public class Const {
    // user是否可登录（非冻结）1=是;2=否
    public static final Integer IS_ENABLE = 2;

    // 前后台登录方式
    public static final int SMS_LOGIN = 1; // 手机验证码登录
    public static final int PASS_LOGIN_ADMIN = 2; // 后台用户名密码登录
    public static final int PASS_LOGIN_APP = 3; // 前台用户名密码登录


    public static final String USER_TYPE_WORKER = "admin"; // 后台员工
    public static final String USER_TYPE_COMMER = "user"; // 前台用户
    public static final String USER_TYPE_PERSON = "person"; // 个人借款人
    public static final String USER_TYPE_COMPANY = "company"; // 企业借款人



    public static final String SMS_CODE_KEY = "APP-SMS-CODE-"; // 存储短信验证码到session中的key前缀，key由前缀和usage组成

    //message表中type消息类型字段值
    public static final Integer SMS_MESSAGE = 1;//短信
    public static final Integer APP_PUSH_MESSAGE = 2; // app推送
    public static final Integer MAIL_MESSAGE = 3; // 邮件
    public static final Integer WX_MESSAGE = 4; //微信
    public static final Integer ZNX_MESSAGE = 5;//站内信


    //融资租赁新增车型中的图片类型
    public static final String CAR_IMG_TYPE = "car_img_type";


    public static final String BANK_PATH = "BANK_PATH"; // 银行logo路径(基准路径是文件根目录)
    public static final String IS_TEST_SMS = "IS_TEST_SMS"; // 测试短信模式发送统一配置 ，1：测试模式，2：正式模式
    public static final String MAX_SEND_TIMES = "MAX_SEND_TIMES"; // 短信无图片验证码最大次数
    public static final String BANK_NEED_CAPTCHA = "BANK_NEED_CAPTCHA"; // 绑定银行卡控制需要图片验证码时间

    // 账户类型
    public static final String ACT_LESSESS = "act_lessess"; // 承租客还款账户
    public static final String ACT_DEALER = "act_dealer"; // 经销商账户

    // 流水类型
    public static final String FT_REPAY = "ft_repay"; // 还款

}
