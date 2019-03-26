package com.jdxm.common.constant;


import java.util.Arrays;
import java.util.List;

/**
 * 业务状态常量
 */
public class OrderStatusConstant {

    /**
     * 授信业务状态开始-----------------------------------------------------------------------
     */
    public static final int CS1 = 1; // 授信删除
    public static final int CS5 = 5; // 打回
    public static final int CS10 = 10; // 授信保存（未提交申请）
    public static final int CS20 = 20; // 待客户经理主管审核
    public static final int CS30 = 30; // 待资信评分表审核
    public static final int CS40 = 40; // 待云风控初审
    public static final int CS50 = 50; // 待风控复审
    public static final int CS60 = 60; // 待授信签约
    public static final int CS70 = 70; // 待总经理审核(最终确认额度)
    public static final int CS100 = 100; // 完成



    public static final String CS_IS_SUMIT = "20,30,40,50,60,70,100"; //已提交
    public static final String CS_IS_CONTRACT = "70,100";//已签约
    public static final String CS_IS_YZZL = "5,10";//影像资料业务列表


    // 授信业务状态结束-----------------------------------------------------------------------


    /**
     * 提款状态从1000开始-------------------------------------------------------------------
     */
    public static final int TK1001 = 1001; // 提款删除
    public static final int TK1005 = 1005; // 提款打回
    public static final int TK1010 = 1010; // 提款保存（未提交）
    public static final int TK1020 = 1020; // 提款已提交(待提款初审)
    public static final int TK1030 = 1030; // 待提款复审
    public static final int TK1040 = 1040; // 待选择资金方
    public static final int TK1060 = 1060; // 待资方审核
    public static final int TK1080 = 1080; // 待财务放款

    public static final int TK2000 = 2000; // 已放款(还款中)
    public static final int TK3000 = 3000; // 完成






    public static final String TK_WAIT_CONTRACT = "1010,1020";//提款待签约

    public static final String TK_IS_SUMIT="1020";//已提交

    public static final String TK_IS_FINAL="2000,3000";//已放款（包括完成）



}
