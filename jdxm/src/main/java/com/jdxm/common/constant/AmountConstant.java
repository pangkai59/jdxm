package com.jdxm.common.constant;

/**
 * 计算金额相关的常量
 */
public class AmountConstant {

    public static final int APR_STYLE_DAY = 1; // 利率类型：天
    public static final int APR_STYLE_MONTH = 2; // 利率类型：月
    public static final int APR_STYLE_YEAR = 4; // 利率类型：年
    public static final int APR_STYLE_WEEK = 5; // 利率类型：周

    public static final int BORROW_PERIOD_DAY = 1; // 借款期限类型:天
    public static final int BORROW_PERIOD_MONTH = 2; // 借款期限类型:月
    public static final int BORROW_PERIOD_SEASON = 3; // 借款期限类型:季
    public static final int BORROW_PERIOD_YEAR = 4; // 借款期限类型:年
    public static final int BORROW_PERIOD_WEEK = 5; // 借款期限类型:周


    public static final int REPAY_PERIOD_DAY = 1; // 还款期限类型:天
    public static final int REPAY_PERIOD_MONTH = 2; // 还款期限类型:月(30天)
    public static final int REPAY_PERIOD_SEASON = 3; // 借款期限类型:季
    public static final int REPAY_PERIOD_YEAR = 4; // 还款期限类型:年
    public static final int REPAY_PERIOD_WEEK = 5; // 还款期限类型:周



    public static final int BORROW_STYLE_DEBX = 0; // 等额本息
    public static final int BORROW_STYLE_DEBJ = 1; // 等额本金
    public static final int BORROW_STYLE_DBDX = 2; // 等本等息
    public static final int BORROW_STYLE_YHXDQHB = 3; // 月还息到期还本
    public static final int BORROW_STYLE_YCXHBFX = 4; // 一次性还本付息
    public static final int BORROW_STYLE_MQHBFX = 5; // 每期还本付息(给自定义天还款用)
    public static final int BORROW_STYLE_YXHXDQHB = 6; // 月先还息，到期还本
    public static final int BORROW_STYLE_DBDXXHX = 7; // 等本等息先还息




}
