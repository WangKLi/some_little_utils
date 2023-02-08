package com.open.little.base;

public enum CodeStatus {

    //成功
    CODE_SUCCESS(20000, "请求成功"),


    /**
     * 服务错误,10***
     * 服务器内部错误(自定义的异常)
     */

    SERVICE_UNKNOWNERROR(10000, "未知原因"),
    SERVICE_UNAVAILABLE(10001, "服务不可用"),
    SERVICE_INTERNELEXCEPTION(10002, "服务内部异常"),
    SERVICE_TOOBUSY(10003, "服务繁忙"),
    SERVICE_TIMEOUT(10004, "服务超时"),
    SERVICE_NOTFOUND(10005, "服务不存在"),
    SERVICE_UNSUPPORTCALL(10006, "不支持的调用方式,请参考API文档"),
    SERVICE_DEPRECATED(10007, "服务已弃用"),

    /**
     * 参数错误,11***
     * 请求参数错误（对GET和POST请求中携带的参数的校验结果）
     */

    //API文档相关,110**
    PARAM_ERROR(11000, "请参考API文档"),
    PARAM_INVALID(11001, "非法参数(),请参考API文档"),
    PARAM_UNSUPPORTMEDIATYPE(11002, "不支持的MEDIATYPE(%S)"),
    PARAM_INVALIDFORMAT(11003, "无效数据格式,请参考API文档"),
    PARAM_INVALIDENCODE(11004, "编码错误,请参考API文档"),
    PARAM_FILEERROR(11005, "暂不支持该格式的文件上传,请您重新上传"),

    //缺少参数,111**
    PARAM_NEEDAPPKEY(11100, "缺少APPKEY"),
    PARAM_NEEDAPIKEY(11101, "缺少APIKEY"),
    PARAM_NEEDSIGN(11102, "缺少SIGN"),
    PARAM_NEEDTIMESTAMP(11103, "缺少时间戳TIMESTAMP"),
    PARAM_REQUIRED_MISS(11104, "缺少必选参数,请参考API文档"),
    PARAM_REQUIRED_FAILURE(11104, "token缺失或失效"),


    //无效参数,112**
    PARAM_INVALIDAPPKEY(11200, "无效APPKEY"),
    PARAM_INVALIDAPIKEY(11201, "无效APIKEY"),
    PARAM_INVALIDSIGN(11202, "无效签名,请参考API文档"),
    PARAM_INVALIDTIMESTAMP(11203, "无效时间戳,请参考API文档"),
    PARAM_INVALIDMOBILE(11204, "该手机号未在本平台注册，请联系本人尽快注册，再进行后续操作！"),
    PARAM_INVALIDCAPTCHA(11205, "无效的图片验证码"),
    PARAM_INVALIDSSMCAPTCHA(11206, "无效的短信验证码"),
    PARAM_INVALIDUSER(11207, "用户不存在"),
    PARAM_EXISTUSER(11208, "用户已存在"),
    PARAM_DIFFERENTMOBILE(11209, "注册的手机号和发送验证码的手机号不一致"),
    PARAM_INVALIDCONSIGNER(11210, "货主不存在"),
    PARAM_EXISTCONSIGNER(11211, "货主已存在"),
    PARAM_INVALIDTRUCKER(11212, "司机不存在"),
    PARAM_EXISTTRUCKER(11213, "司机已存在"),
    PARAM_INVAL_PHONECODE(11214, "无效的手机号"),
    PARAM_EXISTVEHICLE(11215, "该车辆已存在"),
    PARAM_TRAILER_EXISTVEHICLE(11216, "该挂车已存在"),
    PARAM_INVALIDSTORAGE(11217, "站点不存在"),
    PARAM_EXISTCOMPANY(11218,"公司已存在"),
    PARAM_EXIST_SHORT_COMPANY_NAME(11219,"公司简称已存在"),
    PARAM_INVALID_SHORT_COMPANY_NAME(11220,"公司简称不存在"),
    PARAM_INVALID__TRUCKER_INFO_MISS(11221,"请完善资料"),
    PARAM_USERSESSION_EXPIRED(11221,"登陆超时,请重新登陆"),
    PARAM_NOT_HAVE_CHINESE(11223, "不能包含汉字"),
    PARAM_HAVEDSTORAGE(11224, "站点已存在"),
    PARAM_STORAGE_NOT_MATCH_CONTACT(11225, "您没有对应的地址"),
    //

    //失败,113**
    RESULT_FAILEDSENDSSMCAPTCHA(11300, "短信验证码发送失败"),
    RESULT_FAILEDLOGIN(11301, "登录失败"),
    RESULT_MOBILEISREGISTER(11302, "该手机号已被注册"),
    RESULT_FAILEDREGISTER(11303, "注册失败"),
    RESULT_CHECKERPASSWORDLEVEL(11304, "密码安全级别校验"),
    RESULT_FAILED(11305, "请求失败"),
    RESULT_FAILEDBINGING(11306, "添加失败，请重新添加"),
    RESULT_FAILED_UPDATE(11307, "修改资料失败"),
    RESULT_FAILED_INSERT(11308, "添加失败"),
    RESULT_FAILED_OVEROPERATE(11309, "操作过于频繁,请稍后再试"),
    RESULT_FAILED_INSERT_CONTACT(11310, "添加联系人失败"),
    RESULT_FAILED_UPDATECONTACT(11400, "您要操作的联系人已存在地址库中，请查看后重新操作"),
    RESULT_FAILED_UPDATESTATUS(11401, "当前对象无法进行该操作,请核实"),
    RESULT_FAILED_RESUBMIT(11402, "仓库端已有相同的未进场的查询计划,请核实后再操作"),
    RESULT_FAILED_QUEUE_EMPTY(11403, "当前队列已更新,请重新编辑"),
    RESULT_FAILED_VEHICLE_EMPTY(11404, "队列中无该车辆，请刷新后再试"),
    RESULT_FAILED_VEHICLE_NOT_FIRST_OPEN(11405, "当前队列已更新，请刷新后再试"),
    RESULT_FAILED_GOODSNAME_NOT_MATCH(11406, "收发货地址不匹配,请核实后添加"),
    RESULT_FAILED_VEHICLE_EXIST(11407, "队列中已存在该车辆"),
    RESULT_FAILED_UPDATE_QUEUE(11408, "请求操作的队列正在被其他人操作,请稍后再试"),
    RESULT_FAILED_GOODS_EXIST(11409, "该货物已存在"),
    RESULT_FAILED_FLEET_ADD_TRUCKER_EXIST(11410, "您已添加该司机"),
    RESULT_FAILED_FLEET_ADD_TRUCKER_EXIST_UNUPDATE(11411, "您的资料未发生变化，请重新修改"),
    RESULT_FAILED_FLEET_UPDATE_TRUCKER_STATUS_ERROR(11412, "您要修改的司机与贵公司的关系异常,请核实后再操作"),
    RESULT_FAILED_FLEET_GET_TRUCKER_INFO_NULL(11413, "您要获取的司机资料不存在,请核实后再操作"),
    RESULT_FAILED_FLEET_ADD_TRUCKER_ECHO_EXIST(11414, "您要添加该司机已发起了加入申请,运营后台正在审核其资料"),
    RESULT_FAILED_FLEET_ADD_TRUCKER_REGISTER_ERR(11415, "您添加的手机号在注册到sso时异常,请核实后再操作"),
    RESULT_FAILED_FLEET_ADD_TRUCKER_DELETE_ERR(11416, "资料审核未通过，需审核通过后删除"),
    RESULT_FAILED_CHECK_USER_PROTOCOL_ERR(11417, "您已同意了用户协议"),
    RESULT_FAILED_UNCOMPLETE_BILL_DISPATCH_VEHICLE(11418, "该车辆有未完成的单据,请核实后再操作"),
    RESULT_FAILED_FLEET_ADD_TRUCKER_REGISTER_BY_OTHER(11419, "您要添加的司机已在其它应用注册"),
    RESULT_FAILED_VEHICLE_IN_EXAMINING(11420, "该车辆正在审核中"),
    RESULT_FAILED_UPDATE_PASS_VEHICLE_BY_CARD_NUMBER(11420, "该车辆已通过审核，请勿修改车牌号"),
    RESULT_FAILED_DETAIL_NOT_EXIST(11421, "您要查看的信息不存在，请核实后再操作"),
    RESULT_FAILED_FLEET_TRUCKER_STATUS_CHANGE(11422, "司机状态已改变,请刷新司机列表后再操作"),
    RESULT_FAILED_STORAGE_ALEADY_APPOINT(11423, "您已预约该站点"),
    RESULT_FAILED_STATUS_CHANGED(11424, "状态已改变，请刷新后再试"),
    RESULT_FAILED_NO_QUERY(11425, "未查询到数据"),
    RESULT_FAILED_VEHICLE_IN_QUEUE(11426, "车辆排队或预约中，不可删除队列"),
    RESULT_FAILED_LOCATION_ALREADY_APPOINT(11427, "该位置已被预约"),
    RESULT_FAILED_QUEUE_NOT_EXIST(11428, "您操作的队列已不存在,请刷新后重试"),
    RESULT_FAILED_APPOINT_NOT_RICHSCAN(11429, "预约队列暂不支持扫码加入队列"),
    RESULT_FAILED_VEHICLE_CARD_NUMBER_ALREADY_APPOINT(11430, "该车辆已被预约"),
    RESULT_FAILED_VEHICLE_IN_STORAGE(11431, "车辆排队或预约中,暂不能操作开关"),
    RESULT_FAILED_TRUCKER_PHONE_CODE_ALREADY_APPOINT(11432, "该司机已预约"),
    RESULT_FAILED_YOUR_ALREADY_APPOINT(11433, "您已预约"),
    RESULT_FAILED_QUEUE_DELETE(11434, "该队列已删除"),
    RESULT_FAILED_VEHICLE_ALREADY_IN_QUEUE(11435, "该车辆已在队列中，请核实后在操作"),
    RESULT_FAILED_APPOINT_TIME_SLOT_NOT_MATCH_AVG_LOAD_TIME(11436, "预约时间段和平均装车时间不匹配"),
    RESULT_FAILED_SAVE(11437, "该司机不支持保存"),
    RESULT_FAILED_NO_WEIGHT_LEFT(11438, "委托单相关货物的待调度重量为0"),
    RESULT_FAILED_MORE_THAN_WEIGHT(11439, "减少的重量小于待调度的重量"),
    RESULT_FAILED_EXIST_UNCOMPLETE_BILL_TRANSPORT(11439, "减少的重量小于待调度的重量"),
    RESULT_FAILED_TRANSPORT_IS_CHANGED(11440,"运输单已经修改过"),
    RESULT_FAILED_TRUCKER_ADD_VEHICLE(11441,"每个用户仅可添加一辆车，可删除非审核中车辆后进行此操作"),
    RESULT_FAILED_TRANSPORT_EXCEPTION(11442,"运输单已被上传异常"),
    RESULT_FAILED_UPLOAD_IMG(11443,"上传图片失败，请重新上传"),
    RESULT_FAILED_USERINFO_UN_ENTER(11444,"请先提交入驻资料"),
    RESULT_FAILED_TRANSPORT_NOT_EXIST(11445,"运输单不存在"),
    RESULT_FAILED_TRANSPORT_APPOINT(11446,"运输单已经预约过"),
    RESULT_FAILED_SALE_BILL_TO_ORDER(11447,"委托单货物名称或重量填写错误!"),
    RESULT_FAILED_SALE_BILL_TO_ORDER_BATCH(11448,"委托单总量超过销售单可下单量!"),
    RESULT_FAILED_STATUS_OR_LEFT_WEIGHT_CHANGED(11449,"委托单状态或待调度重量已更新，请重新调度!"),
    RESULT_FAILED_INTEGRAL_CONFIG(11450,"积分规则的配置数据失效!"),
    RESULT_FAILED_INTEGRAL_MAX_VALUE(11451,"超过用户增加积分的上限!"),
    RESULT_FAILED_INTEGRAL_REQUEST(11452,"增加积分失败!"),
    RESULT_FAILED_CONTACT_EXIST(11453,"该地址名称已存在!"),
    RESULT_FAILED_TEMPLATE_EXIST(11454,"该模板名称已存在!"),
    RESULT_FAILED_ELECTRON_IS_NOT_CORRECT(11455,"运输次数大于1时，电子运单号不可输，您可在批量调度模板中维护"),
    RESULT_FAILED_DISPATCH_WEIGHT_AND_STATUS_IS_NOT_CORRECT(11456,"调度重量大于待调度重量，请重新输入调度吨数"),
    RESULT_FAILED_BILL_TRANSPORT_STATUS_CHANGED(11457,"该运输单状态已改变无法预约查询"),
    RESULT_FAILED_QUEUE_STATUS_CHANGED_RESTART(11458, "当前队列已更新,请重新选择"),
    RESULT_FAILED_QUEUE_QUERY_RECALL(11459, "撤回失败，请重试"),
    /**
     * 权限安全,12***
     */
    ACCESS_FORBIDDEN(12000, "非法访问"),
    ACCESS_IPFORBIDDEN(12001, "IP访问受限"),
    ACCESS_APPFORBIDDEN(12002, "APP访问受限"),
    ACCESS_APPOVERQUOTA(12003, "APP访问配额超限"),
    ACCESS_APPTOOFREQUENTLY(12004, "APP访问过于频繁"),
    ACCESS_SESSIONFORBIDDEN(12005, "会话访问受限"),
    ACCESS_SESSIONOVERQUOTA(12006, "会话访问配额超限"),
    ACCESS_SESSIONTOOFREQUENTLY(12007, "会话访问过于频繁"),
    ACCESS_USERINACTIVE(12008, "用户未启用,请联系管理员"),

    ACCESS_USERAUTH_DEFICIENCY(12101, "权限不足"),

    COMMUNICATION_FAILED_NETWORK(13001, "访问远程服务失败"),
    COMMUNICATION_ERROR_RESPONSE(13002, "远程服务异常"),

    MULTIPLE_IDENTITY_ERROR(14001, "您的账户存在异常,请尝试其他方式或联系客服"),
    MULTIPLE_IDENTITY_FLEET_ERROR(14002, "您的账户存在异常,请登录物流平台"),
    MULTIPLE_IDENTITY_TRUCKER_ERROR(14003, "您的账户存在异常,请登录司机平台"),
    MULTIPLE_IDENTITY_CONSIGNER_ERROR(14004, "您的账户存在异常,请登录货主平台"),
    MULTIPLE_IDENTITY_CONSIGNER_STAFF(14005, "该帐号已在货主平台入驻"),
    MULTIPLE_IDENTITY_FLEET_STAFF(14006, "该帐号已在物流平台入驻"),
    MULTIPLE_IDENTITY_TRUCKER_STAFF(14007, "该帐号已在司机平台入驻"),
    MULTIPLE_IDENTITY_DATA_ERROR(14008, "您已完善资料，请等待审核！"),
    MULTIPLE_IDENTITY_STORAGE_ERROR(14009, "您的账号处于审核中，请耐心等待！"),
    MULTIPLE_IDENTITY_OTHER_STAFF(14010, "该帐号已在其他平台入驻，请尝试其他方式或联系客服"),
    MULTIPLE_IDENTITY_STORAGE_LOGIN_ERROR(14011, "您的账户存在异常,请登录仓储平台"),
    MULTIPLE_IDENTITY_INTERACT_LOGIN_ERROR(14012, "您的账户存在异常,请登录活动平台"),
    MULTIPLE_IDENTITY_BACK_LOGIN_ERROR(14013, "您的账户存在异常,请登录运营后台"),

    VEHICLE_IS_BLACKLIST(14014, "车辆在黑名单中"),
    VEHICLE_NOT_WHITElIST(14015, "车辆不在白名单中"),

    TRUCKER_IS_BLACKLIST(14020, "司机在黑名单中"),
    TRUCKER_NOT_WHITElIST(14021, "司机不在白名单中"),

    NO_DATA_IN_CACHE(14020, "缓存中无数据"),

    /**
     * 短信相关
     */
    SSM_SUCCESS_SEND(200, "短信发送成功"),
    SSM_FAILED_IPFORBIDDEN(315, "IP限制"),
    SSM_FAILED_INVALIDUSER(404, "对象不存在"),
    SSM_FAILED_VALIDATEERROR(413, "验证失败(短信服务)"),
    SSM_FAILED_PARAMERROR(414, "参数错误"),
    SSM_FAILED_OVEROPERATE(416, "频率控制,今日发送次数超上限"),


    /**
     * 库区预约专属状态码,请勿修改状态码
     */
    SPECIAL_STORAGE_APPOINT_SWITCH_CLOSE_FOR_INFO(15000,"该库区暂未开启预约功能,请直接到现场提货。"),
    SPECIAL_STORAGE_APPOINT_NO_BILL(15001,"很抱歉，由于无相关单据信息,我们暂时无法提供预约功能。"),
    SPECIAL_STORAGE_APPOINT_SWITCH_CLOSE_FOR_APPOINT(15002,"该库区预约功能已关闭,请直接到现场提货或稍后再试。"),
    SPECIAL_STORAGE_QUEUE_APPOINT_SWITCH_CLOSE_FOR_APPOINT(15003,"该队列预约功能已关闭"),


    /**
     * excel 相关
     */
    EXCEL_OVERSTEP_ROW(30000, "您导入的excel超过100行,请您修改文件重新上传"),
    EXCEL_OVERSTEP_ROW_ENTRUST(30003, "您导入的excel超过50行,请您修改文件重新上传"),
    EXCEL_HAS_NO_SHEET(30001, "您导入的excel文件缺失sheet,请重新修改上传"),
    EXCEL_SHEET_IS_EMPTY(30002, "您导入的excel文件内容为空,请重新修改上传"),

    /**
     * UC 相关 40000+
     */
    UC_ERROR_DATAFORMAT(40001, "接口返回格式有改动"),
    UC_ERROR_HTTPTIMEOUT(40002, "接口调用失败"),
    UC_ERROR_USERDISABLE(40003, "当前登录用户已被禁用!"),

    SYS_EXCEPTION(15000,"系统繁忙，请稍后再试"),
    UC_BUSINESS_EXIST_CHECK(15001,"该企业入驻已提交，正在审核中，请耐心等待"),
    UC_BUSINESS_EXIST_PASS(15002,"该公司已认证"),
    UC_BUSINESS_NOT_ALLOW(15002,"该公司不允许认证为该企业类型"),

    /**
     * openapi 相关 41000+
     */
    NO_CONSIGN(41001, "无对应货主公司"),
    CONSIGN_NO_ERROR(41002, "货主自定义单号不唯一"),
    NO_FLEET(41003, "无对应物流公司"),
    SEND_COMPANY_ERROR(41004, "发货地址错误"),
    RECV_COMPANY_ERROR(41005, "收货地址错误"),
    NO_CONSIGN_ADMIN(41006, "货主公司无可用管理员账号"),
    NO_PASS_VEHICLE(41007, "无对应车辆信息"),
    NO_PASS_TRUCKER(41008, "无对应司机信息"),
    NO_DENSITY(41009, "无对应密度"),

    /**
     * 结算单相关 42000+
     */
    NO_FARE_CONFIG(42001,"未查询到结算运费配置数据"),
    TRANSPORT_NOT_COMPLETE(42002,"未完成的运输单"),
    NOT_SUPPORT_TYPE(42003,"不支持的结算方式"),

    /**
     * 访问权限 50000+
     */
    PERM_NOPERMISSION(50001, "无权限访问"),

    /**
     * ocr  60000+
     */
    RESULT_IS_NULL(60001, "ocr返回结果为空"),

    /**
     * 预约队列　7000+
     */
    QUEUE_NOT_EXIST(70001,"队列不存在"),
    QUEUE_NO_DATA(70002,"队列中没有数据"),
    QUEUE_VEHICLE_NOT_MATCH(70003,"与队列中的车牌号不一致"),
    QUEUE_STATUS_NOT_MATCH(70004,"与队列中的状态不一致"),
    QUEUE_NO_APPOINT_RECORD(70005,"未查询到预约记录"),
    QUEUE_NOT_IN_CONTACT(70006,"司机未在库区地址围栏"),
    QUEUE_VEHICLE_IN_BLACK_LIST(70007,"该车辆已被加入黑名单，无法进行查询！请联系【{0}】"),
    QUEUE_TRUCKER_IN_BLACK_LIST(70008,"该司机已被加入黑名单，无法进行查询！请联系【{0}】"),
    QUEUE_QUERY_IS_NOT_MATCH(70009,"抱歉您提交的查询暂无结果，请稍后再试！"),
    QUEUE_QUERY_STORAGE_NO_OPEN_APPOINT_QUEUE(70010,"该库区预约功能已关闭，请直接到现场提货或稍后再试。"),
    QUEUE_TIME_NOT_MATCH(70011,"操作队列时间晚于今天"),
    QUEUE_TIME_SLOT_OCCUPY(70012,"该时间段已被预约，请重新选择"),
    QUEUE_CANCEL_OTHER(70013,"不能取消别人的预约"),
    QUEUE_NOT_MATCH_RULE(70014,"不符合取消时间规则"),
    QUEUE_CANCEL_NOT_MATCH_STATUS(70015,"不可取消预约请尽快赶往现场"),

    QUEUE_CRAFT_INFO_ERROR(70051, "工艺数据存在问题，操作失败！"),
    QUEUE_CRAFT_NAME_EXIST(70052, "工艺名称不能重复！"),
    QUEUE_CRAFT_ID_NOT_NULL(70053, "工艺记录id不能为空！"),
    QUEUE_CRAFT_RULE_SIZE_ERROR(70054, "工艺规则与明细的个数不匹配！"),
    QUEUE_CRAFT_RULE_TIME_ERROR(70055, "工艺规则的时间不正确！"),
    QUEUE_CRAFT_DETAIL_NOT_EXIST(70056, "工艺详情数据不存在！"),
    QUEUE_CRAFT_RULE_CONTENT_CHANGE(70057, "工艺规则时段内容不允许修改！"),


    /**
     * 支付配置　8000+
     */
    PAY_CONFIG_EXIST(80001, "该库区配置已存在！"),
    PAY_CONFIG_NO_EXIST(80002, "无法购买该服务！"),
    PAY_CONFIG_DEFINE(80003, "请先配置或开启该库区的单次收费规则! "),
    PAY_CONFIG_PRICE_ZERO(80004, "价格不能为零! "),
    PAY_CONFIG_NO_SERVER(80005, "该服务暂未开通！"),


    PAY_REQ_ERROR(80021, "支付请求通信失败! "),
    PAY_FAIL(80022, "支付请求返回内容失败! "),
    PAY_SIGN_ERROR(80023, "支付请求签名不通过！"),
    PAY_BIZ_PARAM_ERROR(80024, "支付参数不符合业务要求！"),
    PAY_APPOINT_TO_LIMIT(80025, "该时段已满，请选择其它时段！"),
    PAY_KEY_OVERDUE(80026, "支付请求的秘钥已经过期！"),
    PAY_NO_ORDER(80027, "没有此订单，或已超时！"),
    PAY_NOTIFY_STATUS_ERROR(80028, "结果通知已收到，但不符合当前业务逻辑！"),
    PAY_QUEUE_BUSY(80029, "当前队列繁忙，请重试！"),
    PAY_COMMON_ERROR(80030, "支付失败，请重新支付！"),

    ORDER_NOT_SUPPORT_REFUND(80031,"该订单不支持退款！"),
    ORDER_REFUND_FAIL(80032,"订单退款失败！"),
    ORDER_REFUND_EMPTY(80033,"退款网关返回为空！"),
    ORDER_REFUNDING(80034,"订单退款中！"),
    ORDER_REFUNDED(80035,"订单退款完成！"),
    ORDER_NULL(80036,"订单不存在！"),
    ORDER_QUERY_FAIL(80037,"网关支付查询失败! "),
    PAY_APPOINT_EXIST(80038, "已预约或有待支付订单，请检查后再次发起支付！")
    ;

    private int value;
    private String name;

    CodeStatus(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }


    /**
     * @param code 状态码
     * @return 状态枚举
     * @desc 通过状态码查询状态枚举
     */
    public static CodeStatus getEnum(int code) {
        if (code == 0) {
            return null;
        }
        for (CodeStatus codeStatus : CodeStatus.values()) {
            if (codeStatus.getValue() == code) {
                return codeStatus;
            }
        }
        return null;
    }
}
