package com.jdxm.common.base;


public class Constant {

    // 收费类型
    public static final String TTYPE_COMMON_FEE = "common_fee"; // 普通收费
    public static final String TTYPE_BZJ_FEE = "bzj_fee"; // 保证金
    public static final String TTYPE_YAJIN_FEE = "yajin_fee"; // 押金
    public static final String TTYPE_ZJF_FEE = "zjf_fee"; // 中介费

    // 充值申请审核状态
    public static final int CHARGE_CHECK_REDAY = 1; // 新增待审核
    public static final int CHARGE_CHECK_PASS = 2; // 审核通过
    public static final int CHARGE_CHECK_FAIL = 3; // 审核失败
    public static final int CHARGE_CHECK_MONEY_ARRIVE = 4; // 审核通过付款完成


    public static final int BORROW_STYLE_DBDX = 2; // 等本等息
    public static final int BORROW_STYLE_MQHBFX = 5; // 每期还本付息(给自定义天还款用)
    public static final int BORROW_STYLE_YXHXDQHB = 6; // 月先还息，到期还本
    public static final int BORROW_STYLE_DBDXXHX = 7; // 等本等息(先还息)


    public static final int BORROW_PERIOD_DAY = 1;
    public static final int BORROW_PERIOD_MONTH = 0;
    public static final int BORROW_PERIOD_SEASON = 2;

    public static final int REPAY_PERIOD_DAY = 1;
    public static final int REPAY_PERIOD_MONTH = 2;
    public static final int REPAY_PERIOD_NATURE_MONTH = 3;
    public static final int REPAY_PERIOD_SEASON = 4;
    public static final int REPAY_PERIOD_CUSTOM_DAY = 5;

    // OBJTYPE
    public static final String BUSINESS_OBJTYPE_CREDIT = "credit";

    public static final String BUSINESS_OBJTYPE_BID = "bid";

    // 页码
    public static final int PAGE_PAGE = 1;
    // 每页条数
    public static final int PAGE_SIZE = 20;

    // 页码（字符串版）
    public static final String PAGE_PAGE_S = "1";
    // 每页条数（字符串版）
    public static final String PAGE_SIZE_S = "20";

    // 业务状态
    public static final int BS_REJECTED = 1; // 拒借
    public static final int BS_VOID = 2; // 作废
    public static final int BS_REPULSE = 5; // 驳回
    public static final int BS_SUBMITED = 20; // 已提交-待面审
    public static final int BS_FACE_TRIAL = 15; // 已面审-待风控
    public static final int BS_RISK_CONTROLED = 40; // 已风控-待店长审核
    public static final int BS_SIGN_WAIT = 70; // 待签约
    public static final int BS_JK_GENERAL_REVIEW = 94; // 总经理待审核放款
    public static final int BS_JK_RONGZI_REVIEW = 97; // 投融部_待审核放款
    public static final int BS_CS_OVER_WAIT_APPLY = 890; //催收款已收回，待发起结案申请
    public static final int BS_CS_OVER_WAIT_CONFIRM = 900; //已发起结案申请，待总部确认结案
    public static final int BS_OVER = 1000; // 已完结
    public static final int BS_CANCEL_UNLOCK = 2; // ERP客户业务取消待解锁
    public static final int BS_LOCK_PENDING = 7; // ERP客户发起业务，待审核
    public static final int BS_OVER_UNLOCK = 990; // ERP客户业务还款结束待解锁
    public static final int BS_DELETED = -1; // 已删除

    public static final int BS_SUBMIT_PENDING = 10; // 已提交-待面审(小二贷)
    public static final int BS_MENDIAN_OK = 20; // 面审通过-待签约(小二贷)
    public static final int BS_SIGNED = 30; // 已签约-待总部总部分配(小二贷)
    public static final int BS_DISTRIBUTION = 40; // 已分配-待总部初审(小二贷)
    public static final int BS_ASSESSMENT = 50; // 已初审-待风控审核(小二贷)
    public static final int BS_ZONGBU_OK = 60; // 分控已审核-待总部复审(小二贷)
    public static final int BS_ZONGBU_CONFIRMED = 90; // 总部已复审-待选择资方(小二贷)
    public static final int BS_TENDER_CHOSED = 100; // 资方已选择-待资方审核／总部终审(小二贷)
    public static final int BS_WAIT_LOAN = 110; // 资方审核／总部终审通过-待放款(小二贷)
    public static final int BS_LOANED = 120; // 已放款(小二贷)


    // 用户类型
    public static final String USER_TYPE_PERSON = "person";
    public static final String USER_TYPE_COMPANY = "company";
    public static final String USER_TYPE_TENDER = "tender";
    public static final String USER_TYPE_WORKER = "worker";

    // 黑名单标记
    public static final String BLACK_LIST_FLAG = "2";
    // 担保方案提交
    public static final Integer DBFA_SUB = 2;

    // 综合授信业务状态。
    public static final int CS_SUBMIT_PENDING = 10; //新增-待提交
    public static final int CS_RETURN = 12; // 打回
    public static final int CS_SUBMITED = 20; // 已提交-待风控
    public static final int CS_FACE_TRIAL = 30; // 已风控-待副总审核
    public static final int CS_VICE_OK = 40; // 副总审核通过-待总经理审核
    public static final int CS_GENERAL_OK = 50; // 总经理审核通过-等待待审会秘书
    public static final int CS_DSH_START = 60; // 贷审会发起-等待审批
    public static final int CS_DSH_MEMBER_SUBMIT = 70; // 贷审会审批完成-等待决议
    public static final int CS_DSH_OVER = 80; // 贷审会决议完成

    // 抵押物类型
    public static final Integer DIYA_TYPE_CAR = 1; // 车辆
    public static final Integer DIYA_TYPE_HOUSE = 2; // 房产
    public static final Integer DIYA_TYPE_CURRENCY = 3; // 通用

    // 贷审会成员类型
    public static final String RMT_USER_TYPE_CHAIRMAN = "C"; // 主席
    public static final String RMT_USER_TYPE_MEMBER = "M"; // 成员
    public static final String RMT_USER_TYPE_SECRETARY = "S"; // 秘书
    public static final String RMT_USER_TYPE_YEWU = "Y"; // 业务员

    //抵押物评估状态
    public static final int DYWPG__ADD = 2;// 已添加
    public static final int DYWPG__COMMIT = 5;// 添加提交
    public static final int DYWPG_SAVE = 7;// 评估保存
    public static final int DYWPG__OK = 10;// 评估完成

    // 贷审会状态
    public static final Integer RMT_STATUS_FAQI = 1; // 新建，未发起
    public static final Integer RMT_STATUS_SHENPI = 2; // 发起，进行中，可以审批
    public static final Integer RMT_STATUS_JUEYI = 3; // 决议中
    public static final Integer RMT_STATUS_OVER = 4; // 结束

    // 审贷会"审批轮"的状态
    public static final Integer RMT_ROUND_ING = 1; // 进行中
    public static final Integer RMT_ROUND_OVER = 2; // 结束

    public static final Integer RMT_RETURN_WAIT = 1; // 打回的业务 等待业务员补录
    public static final Integer RMT_RETURN_OVER = 2; // 打回的业务 补录提交

    // 贷审会结果
    public static final Integer RMT_PASS = 1; // 通过
    public static final Integer RMT_REJECT = 2; // 不通过
    public static final Integer RMT_RETURN = 3; // 驳回
    public static final Integer RMT_NOT_OVER = 4; // 一轮还没结束

    // 贷审会类型
    public static final Integer RMT_TYPE_GA = 1; // 产品申请
    public static final Integer RMT_TYPE_CREDIT = 2; // 综信
    public static final Integer RMT_TYPE_BORROW = 3; // 借款

    // 第三方应用激活状态
    public static final Integer OPEN_APP_ACTIVE = 1; // 激活
    public static final Integer OPEN_APP_INACTIVE = 2; // 未激活

    //短信发送session缓存前缀
    public static final String SESS_KEY_MOBCODE_PREFIX = "MOBCODE_";
    //图片验证码的key
    public static final String SESS_KEY_VERIFYCODE_PREFIX = "SESS_VERIFYCODE_";

    // 一次性还款申请状态
    public static final Integer OTR_STATUS_NONE = 0; // 未申请
    public static final Integer OTR_STATUS_REJECT = 2; // 拒绝
    public static final Integer OTR_STATUS_APPLY = 10; // 申请 待副总审核
    public static final Integer OTR_STATUS_FZSH = 20; // 待总经理审核
    public static final Integer OTR_STATUS_ZJLSH = 30; // 待一次性还款
    public static final Integer OTR_STATUS_DONE = 40; // 一次性还款完成

    // 审核类型
    public static final Integer CHECK_TYPE_BID_FZSH = 1; // 店长面审
    public static final Integer CHECK_TYPE_BID_ZJLSH = 2; // 总部初审
    public static final Integer CHECK_TYPE_FK_APPLY = 3; // 总部分控
    public static final Integer CHECK_TYPE_FK_FZSH = 4; // 总部复审
    public static final Integer CHECK_TYPE_FK_ZJLSH = 5; // 总部终审
    public static final Integer CHECK_TYPE_FK_TRZ = 6; //
    public static final Integer CHECK_TYPE_FK_DSHZR = 7; // 放款贷审会主任审核
    public static final Integer CHECK_TYPE_OTR_APPLY = 8; // 一次性还款申请
    public static final Integer CHECK_TYPE_OTR_FZSH = 9; // 一次性还款副总审核
    public static final Integer CHECK_TYPE_OTR_ZJLSH = 10; // 一次性还款总经理审核
    public static final Integer CHECK_TYPE_BID_KHJL = 11; // 客户记录审核
    // 审核动作
    public static final Integer CHECK_STATUS_SAVE = 0; // 保存
    public static final Integer CHECK_STATUS_RETURN = 1; // 退回
    public static final Integer CHECK_VOID = 2; // 作废
    public static final Integer CHECK_STATUS_SUBMIT = 10; // 提交
    public static final Integer CHECK_STATUS_REJECT = 20; // 拒绝

    public static final String CHECK_CATE_BORROW = "borrow"; // 借款／综信的审核
    public static final String CHECK_CATE_FANGKUAN = "fangkuan"; // 放款的审核
    public static final String CHECK_CATE_OTR = "otr"; // 一次性还款申请的审核

    //业务整体流程状态 控制业务环节是不是能继续往后走 1:可以 2:不可以，驳回中
    public static final Integer FLOW_STATUS_YES = 1;
    public static final Integer FLOW_STATUS_NO = 2;

    //角色ID
    public static final Integer ROLE_KFJL = 8;
    public static final Integer ROLE_KFZG = 58;
    public static final Integer ROLE_DZ = 59;
    public static final Integer ROLE_ZBZG = 60;
    public static final Integer ROLE_ZBKF = 61;
    public static final Integer ROLE_ZBFK = 56;
    public static final Integer ROLE_FZ = 62;
    public static final Integer ROLE_CW = 52;
    public static final Integer ROLE_CC = 53;
    public static final Integer ROLE_JMSCW = 70;
    public static final Integer ROLE_JMSCC = 71;

    // 公司划分级别，比如：对应角色会不一样
    public enum COM_LEVEL {
        ZONGBU("ZONGBU"), // 公司级别：总部
        GONGSI("GONGSI"), // 公司级别：公司
        ZIFANG("ZIFANG"); // 公司洁白：资方

        private String value;

        COM_LEVEL(String value) {
            this.value = value;
        }

        public String value() {
            return value;
        }
    }

    // 业务系统标志
    public enum SYS_CATE {
        LOAN("loan"), // 小贷业务系统
        PAWN("pawn"), // 典当业务系统
        GROUP("group"); // 集团业务系统

        private String value;

        SYS_CATE(String value) {
            this.value = value;
        }

        public String value() {
            return value;
        }
    }

    // 工作流节点内的关系
    public enum WF_NODE_RELATION {
        NONE, // 说明是叶子节点，没有其他子节点
        MULTI, // 说明该节点内存在一个多选节点组，可以是两个节点都要完成，也可以是三个节点需要完成两个
        TURN // 说明该节点内存在一个一次执行的节点组，节点组内每个节点按次序一个个都要完成
    }

    // 工作流操作
    public enum WF_OP {
        FLAG_START, // 标记开始
        PASS, // 通过
        REJECT, // 驳回
        JUMP, // 打回
        SAVE, // 保存
        SKIP // 忽略
    }

    // 工作流节点状态
    public enum WF_NODE_STATUS {
        NONE, // 初始状态
        WAIT, // 本轮可以操作的
        WAIT_ERR, // in执行失败,
        PASS, // 通过了的
        REJECT, // 驳回了的
        JUMP, // 打回了的
        FLAG_START, // 标记开始了的 xx客户提到这个需求，遂加入
        SAVE // 保存了的
    }

    // 单次操作的进度
    public enum WF_OP_LOG_PROGRESS {
        INIT, // 入参检查通过后，就记录日志了，此时是INIT
        LOCKED, // 是否锁定检查后，日志和事项关联，即本次操作锁定了事项，此时是START
        WAIT_CHECKED, // 当前请求的操作能进行，是wait状态的节点
        AH_LOADED, // 待操作节点的ActionHandler加载成功了
        FAIL, // 本次操作失败
        SUCCESS, // 本次操作成功
    }

    // 事项的状态
    public enum WF_WORK_STATUS {
        NONE, // 初始状态
        PROCESSING, // 进行中
        FINISH, // 已完成
        CANCEL, // 取消
        ARCHIVE // 归档
    }

    // 流程动作，这里的定义要跟`flow_action`表对应起来的
    // 现在的命名以对应动作的中文名的全拼拼音来命
    public enum WF_ACTION {

        TJDYW("添加抵押物"),
        TJYXZL("添加影像资料"),
        DYWPG("抵押物评估"),
        YWTJ("业务提交"),
        TJMSD("提交面审单"),
        FKDF("风控打分"),

        ZBDYWPG("总部抵押物评估"),
        ZBSH("总部审核"),
        MDKHJLQR("门店客户经理确认"),

        SCQYSP("上传签约视频"),
        SCGDZL("上传归档资料"),
        ZBQR("总部确认"),
        XZZYZJ("选择自有资金"),
        ZFTJJG("资方提交结果"),
        TJFWDYW("添加房屋抵押物"),
        FWDYWPG("房屋抵押物评估"),
        ZBFWDYWPG("总部房屋抵押物评估"),

        DBFA("担保方案"),
        ZX_YWDJ("综信业务登记"),
        ZX_YWTJ("综信业务提交"),

        RMT_VOTE("审贷会审批"),
        RMT_DECIDE("审贷会决议"),
        DCBG("调查报告提交"),
        CWSQFK("财务申请放款"),
        VM_FK_CHECK("财务放款副总经理审核"),
        GM_FK_CHECK("财务放款总经理审核"),
        MANAGER_CHECK("投融资部总经理审核"),
        BOSS_CHECK("贷审会主任审核"),

        FAKE_DSH("绕过贷审会用的虚拟节点"),
        DIYA_INOUT_APPLY("抵押物出入库申请"),
        DIYA_F_CHECK("抵押物出库财务审核"),
        DIYA_VP_CHECK("抵押物出入库副总审核"),
        DIYA_GM_CHECK("抵押物出入库老总审核"),
        DIYA_INOUT("抵押物出入库操作"),
        DIYA_INOUT_CONFIRM("抵押物出入库确认"),


        YWDJ("业务登记"),
        DZSH("店长面审"),
        SCHT("签约"),
        ZBSHZYLQRW("审核人员分配"),
        ZBCS("总部初审"),
        FKSH("分控审核"),
        ZBFS("总部复审"),
        XZZF("选择资方"),
        ZBZS("总部终审"),
        CWFK("财务放款"),

        GA_NEW("产品申请"),
        GA_FZSH("产品申请副总审核"),
        GA_ZJLSH("产品申请总经理审核");


        private String value;

        WF_ACTION(String value) {
            this.value = value;
        }

        public String value() {
            return value;
        }
    }

    public enum COMPANY_CATE {
        COMPANY(1),
        TENDER(2);

        private Integer value;

        COMPANY_CATE(Integer value) {
            this.value = value;
        }

        public Integer value() {
            return value;
        }
    }


    /**
     * 根据综信状态值获取状态值描述
     *
     * @param status 综合授信业务状态
     * @return 状态描述
     */
    public static String getCreditStatus(Integer status) {

        String describe; //中文描述

        switch (status) {
            case CS_SUBMIT_PENDING:
                describe = "待提交";
                break;
            case CS_SUBMITED:
                describe = "已提交";
                break;
            case CS_FACE_TRIAL:
                describe = "待副总审核";
                break;
            case CS_VICE_OK:
                describe = "待总经理审核";
                break;
            case CS_GENERAL_OK:
                describe = "待审会秘书操作";
                break;
            case CS_DSH_START:
                describe = "等待贷审会审批";
                break;
            case CS_DSH_MEMBER_SUBMIT:
                describe = "等待决议";
                break;
            case CS_DSH_OVER:
                describe = "贷审会决议完成";
                break;
            case CS_RETURN:
                describe = "打回";
                break;
            case BS_LOCK_PENDING:
                describe = "等待ERP确认";
                break;
            case BS_CANCEL_UNLOCK:
                describe = "等待ERP确认";
                break;
            case BS_OVER_UNLOCK:
                describe = "等待ERP确认";
                break;
            default:
                describe = "未知状态";
                break;
        }
        return describe;
    }

    // 支持的上传的文件格式
    public static final String VALIDFILETYPES = "jpg,gif,jpeg,bmp,png,pdf";


}
