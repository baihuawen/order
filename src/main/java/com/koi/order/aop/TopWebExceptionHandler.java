package com.koi.order.aop;


import com.koi.order.entityy.Result;
import com.koi.order.entityy.ResultCodeEnum;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

/**
 * web 调用发生的异常，统一到这里处理，如需直接操作 http 保文，可以实现 WebExceptionHandler
 */
@RestControllerAdvice
@Slf4j
public class TopWebExceptionHandler {
    private Integer errcode;


    @ExceptionHandler(Exception.class)
    public Result handleAppException(WebRequest request, Exception exception) {
        log(exception, request);
        String errUid = MDC.get(LogRequestInterceptor.TRACE_ID);
        String notice = exception.getMessage();
        Result ret = Result.error(ResultCodeEnum.COMMON_FAIL, notice, errUid);
        int code = errcode * 1000 + ret.getCode();
        ret.setCode(code);
        return ret;
    }

    private void log(Exception exception, WebRequest request) {
        log.error("error-code:{}", MDC.get(LogRequestInterceptor.TRACE_ID));
        log.error(exception.getMessage(), exception);
        Throwable t = exception;
        while (t.getCause() != null) {
            t = t.getCause();
            log.error(t.getMessage(), t);
        }
    }
}
