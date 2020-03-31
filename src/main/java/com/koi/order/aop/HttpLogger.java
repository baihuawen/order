package com.koi.order.aop;

import lombok.extern.slf4j.Slf4j;
import okhttp3.logging.HttpLoggingInterceptor;


/**
 * @Author fitz.bai
 * @Date 2020-03-31 15:30
 */
@Slf4j
public class HttpLogger implements HttpLoggingInterceptor.Logger {
    @Override
    public void log(String s) {
        log.info("a==" + s);
    }
}
