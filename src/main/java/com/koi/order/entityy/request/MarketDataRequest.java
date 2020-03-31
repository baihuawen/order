package com.koi.order.entityy.request;

import java.util.List;

/**
 * @Author fitz.bai
 * @Date 2020-03-30 17:20
 */
public class MarketDataRequest {
    private String SubscriptionRequestType;
    private List<String> symbols;

    public String getSubscriptionRequestType() {
        return SubscriptionRequestType;
    }

    public void setSubscriptionRequestType(String subscriptionRequestType) {
        SubscriptionRequestType = subscriptionRequestType;
    }

    public List<String> getSymbols() {
        return symbols;
    }

    public void setSymbols(List<String> symbols) {
        this.symbols = symbols;
    }
}
