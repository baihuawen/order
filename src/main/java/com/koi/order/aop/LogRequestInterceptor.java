package com.koi.order.aop;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.boot.web.servlet.context.ServletWebServerInitializedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.RequestHandledEvent;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * @author xu.zeng
 * @date 2019-03-22 19:30
 */
@Component
@Slf4j
public class LogRequestInterceptor implements HandlerInterceptor {
    static final String TRACE_ID = "X-B3-TraceId";
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        if(MDC.get(TRACE_ID)==null){
            MDC.put(TRACE_ID, UUID.randomUUID().toString().substring(10));
        }
        return true;
    }


    @EventListener(RequestHandledEvent.class)
    public void logRequest(RequestHandledEvent handledEvent){
        log.info("{}", handledEvent.getDescription());
    }

    @EventListener(ServletWebServerInitializedEvent.class)
    public void logRequest(ServletWebServerInitializedEvent initEvent){
        log.info("{}", initEvent);
    }
}
