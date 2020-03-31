package com.koi.order.entityy;

import lombok.Data;

/**
 * @author xu.zeng
 * @date 2019-02-25 14:31
 */
@Data
public class Result<T>{
    private Integer code;
    private String msg;
    private T data;

    public Result(){}

    public Result(ResultCodeEnum resultCodeEnum, T data) {
        this.code = resultCodeEnum.getCode();
        this.msg = resultCodeEnum.getDesc();
        this.data = data;
    }

    public static Result<Object> success() {
        return success(null);
    }

    @SuppressWarnings("unchecked")
    public static <T> Result<T> success(T data) {
        return new Result(ResultCodeEnum.COMMON_SUCCESS, data);
    }

    public static Result<Object> error() {
        return error("执行失败");
    }

    public static Result<Object> error(String notice) {
        return error(ResultCodeEnum.COMMON_FAIL, notice);
    }

    public static Result<Object> error(ResultCodeEnum resultCodeEnum, String notice){
        @SuppressWarnings("unchecked") Result<Object> ret = new Result(resultCodeEnum, null);
        ret.setMsg(resultCodeEnum.getDesc().concat(",").concat(notice));
        return ret;
    }

    public static Result<String> error(ResultCodeEnum resultCodeEnum, String notice, String data){
        Result<String> ret = new Result(resultCodeEnum, data);
        ret.setMsg(resultCodeEnum.getDesc().concat(",").concat(notice));
        return ret;
    }
}
