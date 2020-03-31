package com.koi.order.entityy.request;

/**
 * @Author fitz.bai
 * @Date 2020-03-29 15:46
 */
public class QuoteRequest {
    private String Symbol;
    private String Side;
    private Integer OrderQty;
    private String QuoteReqID;

    public String getSymbol() {
        return Symbol;
    }

    public void setSymbol(String symbol) {
        Symbol = symbol;
    }

    public String getSide() {
        return Side;
    }

    public void setSide(String side) {
        Side = side;
    }

    public Integer getOrderQty() {
        return OrderQty;
    }

    public void setOrderQty(Integer orderQty) {
        OrderQty = orderQty;
    }

    public String getQuoteReqID() {
        return QuoteReqID;
    }

    public void setQuoteReqID(String quoteReqID) {
        QuoteReqID = quoteReqID;
    }
}
