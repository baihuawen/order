package com.koi.order.entityy;

/**
 * @author fitz.bai
 */

public enum ResultCodeEnum {
    COMMON_SUCCESS(0, "成功"),
    COMMON_FAIL(1, "失败"),
    BUSINESS_INVALID(2, "业务操作非法"),
    DATA_ACCESS_FAIL(3, "数据库操作异常"),
    REMOTE_INVOKE_FAIL(4, "远程调用异常"),
    PARAM_INVALID(21, "参数错误"),
    SAFE_GROUP(22, "安全组操作异常"),
    MAIL_GROUP(23, "邮件组操作异常"),
    HANG_UP(28, "业务处理挂起"),
    DATA_NOT_EXIST(31, "对应记录不存在");

    private Integer code;
    private String desc;

    ResultCodeEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public static String getDesc(int code) {
        String result = null;
        for (ResultCodeEnum bcode : ResultCodeEnum.values()) {
            if (bcode.code == code) {
                result = bcode.desc;
            }
        }
        return result;
    }
}
