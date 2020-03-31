package com.koi.order.util;

import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

/**
 * @Author fitz.bai
 * @Date 2020-03-29 15:39
 */
@Component
@Slf4j
public class HttpUtil {

    private static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");


    /**
     * 统一okhttp的get请求
     *
     * @param url
     * @return
     * @throws IOException
     */
    public static void doGet(String url) throws IOException {
        doGet(url, null, null);
    }


    public static void doGet(String url, Map<String, String> params) throws IOException {
        doGet(url, params, null);
    }

    public static void doGet(String url, String[] headers) throws IOException {
        doGet(url, null, headers);
    }

    public static void doGet(String url, Map<String, String> params, String[] headers) throws IOException {
        StringBuilder sb = new StringBuilder(url);
        if (params != null && params.keySet().size() > 0) {
            boolean firstFlag = true;
            for (String key : params.keySet()) {
                if (firstFlag) {
                    sb.append("?").append(key).append("=").append(params.get(key));
                    firstFlag = false;
                } else {
                    sb.append("&").append(key).append("=").append(params.get(key));
                }
            }
        }

        Request.Builder builder = new Request.Builder();
        if (headers != null && headers.length > 0) {
            if (headers.length % 2 == 0) {
                for (int i = 0; i < headers.length; i = i + 2) {
                    builder.addHeader(headers[i], headers[i + 1]);
                }
            }

        }

        Request request = builder.url(sb.toString()).build();
        executeGet(request);
    }

    /**
     * 统一okhttp的post请求
     *
     * @param url
     * @param json
     * @return
     * @throws IOException
     */
    public static String doPostJson(String url, String json) throws IOException {
        return exectePost(url, json, JSON);
    }

    private static String exectePost(String url, String data, MediaType contentType) throws IOException {
        RequestBody requestBody = RequestBody.create(contentType, data);
        log.info("requestBody====" + requestBody.toString());
        Request request = new Request.Builder().url(url).post(requestBody).build();

        return execute(request);
    }

    private static String execute(Request request) throws IOException {
        OkHttpClient okHttpClient = new OkHttpClient();
        Response response = null;
        try {
            response = okHttpClient.newCall(request).execute();
            if (response.isSuccessful()) {
                return response.body().string();
            }
        } finally {
            if (response != null) {
                response.close();
            }
        }
        return "";
    }

    private static void executeGet(Request request) throws IOException {
        OkHttpClient okHttpClient = new OkHttpClient();
        okHttpClient.newCall(request).execute();
    }
}
