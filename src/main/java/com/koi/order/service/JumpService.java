package com.koi.order.service;

import com.google.gson.Gson;
import com.koi.order.entityy.request.*;
import com.koi.order.entityy.response.MarketDataResponse;
import com.koi.order.entityy.response.OrderSingleResponse;
import com.koi.order.entityy.response.OrderStatusResponse;
import com.koi.order.entityy.response.QuoteResponse;
import com.koi.order.util.HttpUtil;
import com.koi.order.util.SignatureUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


/**
 * @Author fitz.bai
 * @Date 2020-03-29 10:31
 */
@Component
@Slf4j
public class JumpService {
    public final static Gson GSON = new Gson();
    //指定的APIKEY：JLQD login name used to administer API secrets
    public final static String KEY = "hzhou-test";
    public final static String SECRET = "b79e2ca388f6d8df7ef9a0de1a3ec4e2";

    public static void main(String[] args) {
        MarketDataRequest request = new MarketDataRequest();
        List<String> a = new ArrayList<>();
        a.add("a");
        request.setSubscriptionRequestType("1");
        request.setSymbols(a);
        System.out.println(GSON.toJson(request));
    }

    /**
     * 弃用，访问报价，使用marketDataRequest
     *
     * @param request
     * @return
     * @throws Exception
     */
    public QuoteResponse quoteRequest(QuoteRequest request) throws Exception {
        request.setQuoteReqID(UUID.randomUUID().toString());
        String response = HttpUtil.doPostJson("https://uat.jumpliquidity.com/v2/quoteRequest"
                + getRequestParms(request, KEY, SECRET), GSON.toJson(request));

        return GSON.fromJson(response, QuoteResponse.class);
    }

    /**
     * 新建订单
     *
     * @param request
     * @return
     * @throws Exception
     */
    public OrderSingleResponse newOrderSingle(OrderSingleRequest request) throws Exception {
        request.setSymbol("ETHUTC");
        request.setClOrdID(UUID.randomUUID().toString());
        request.setOrdType("2");
        request.setTimeInForce("4");
        request.setSide("1");
        request.setPrice(1.2);
        request.setOrderQty(2.2);
        request.setEndUserID("hzhou-test");
        request.setManaged(0);
        String response = HttpUtil.doPostJson("https://uat.jumpliquidity.com/v2/newOrderSingle"
                + getRequestParms(request, KEY, SECRET), GSON.toJson(request));
        log.info("====" + response);
        return GSON.fromJson(response, OrderSingleResponse.class);
    }

    /**
     * 查看订单状态
     *
     * @param request
     * @return
     * @throws Exception
     */
    public OrderStatusResponse orderStatus(OrderStatusRequest request) throws Exception {
        List<String> list = new ArrayList<>();
        list.add("1829312hj124ygh1i24h1oi4");
        request.setLstOrderIds(list);
        String response = HttpUtil.doPostJson("https://uat.jumpliquidity.com/v2/orderStatus"
                + getRequestParms(request, KEY, SECRET), GSON.toJson(request));
        log.info("====" + response);
        return GSON.fromJson(response, OrderStatusResponse.class);
    }

    /**
     * 询价
     *
     * @param request
     * @return
     * @throws Exception
     */
    public MarketDataResponse marketDataRequest(MarketDataRequest request) throws Exception {
        request.setSubscriptionRequestType("1");
        log.info("request====" + request.toString());
        log.info("json====" + GSON.toJson(request));

        String response = HttpUtil.doPostJson("https://uat.jumpliquidity.com/v2/marketDataRequest"
                + getRequestParms(request, KEY, SECRET), GSON.toJson(request));
        log.info("====" + response);
        return GSON.fromJson(response, MarketDataResponse.class);
    }

    /**
     * 启动Jump的访问
     * 所有Jump接口访问的BASE
     *
     * @throws Exception
     */
    public void streamingEvents() throws Exception {
        QuoteRequest request = new QuoteRequest();
        request.setSymbol("ETCUSD");
        request.setSide("1");
        request.setOrderQty(1);

        log.info(("https://uat.jumpliquidity.com/v2/streamingEvents"
                + getRequestParms(request, KEY, SECRET)));
        HttpUtil.doGet("https://uat.jumpliquidity.com/v2/streamingEvents"
                + getRequestParms(request, KEY, SECRET));
    }

    /**
     * 所有Jump接口访问后，最好进行logout操作
     *
     * @throws Exception
     */
    public void logout() throws Exception {
        QuoteRequest request = new QuoteRequest();
        request.setSymbol("ETCUSD");
        request.setSide("1");
        request.setOrderQty(1);

        HttpUtil.doPostJson("https://uat.jumpliquidity.com/v2/logout"
                + getRequestParms(request, KEY, SECRET), GSON.toJson(request));
    }

    /**
     * 获取请求参数拼接在url后
     *
     * @param payload
     * @param key
     * @param secret
     * @param <T>
     * @return
     * @throws Exception
     */
    <T> String getRequestParms(T payload, String key, String secret) throws Exception {
        RequestFormat requestFormat = SignatureUtil.makePostBody(payload, key, secret);
        StringBuffer stringBuffer = new StringBuffer();
        //?APIKEY=apikey&PAYLOAD=payload&NONCE=nonce&SIGNATURE=signature
        stringBuffer.append("?APIKEY=").append(requestFormat.getKey())
                .append("&PAYLOAD=").append(requestFormat.getPayload())
                .append("&NONCE=").append(requestFormat.getNonce())
                .append("&SIGNATURE=").append(requestFormat.getSignature());

        return stringBuffer.toString();
    }
}
