package com.koi.order.entityy.response;

import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * @Author fitz.bai
 * @Date 2020-03-30 17:21
 */
public class MarketDataResponse {
    private String BeginString;
    private String MsgType;
    private Integer MsgSeqNum;
    private String SendingTime;
    private List<String> subSymbols;
    private Map<String, Object> books;

    public MarketDataResponse(String beginString, String msgType, Integer msgSeqNum, String sendingTime, List<String> subSymbols, Map<String, Object> books) {
        BeginString = beginString;
        MsgType = msgType;
        MsgSeqNum = msgSeqNum;
        SendingTime = sendingTime;
        this.subSymbols = subSymbols;
        this.books = books;
    }

    public String getBeginString() {
        return BeginString;
    }

    public void setBeginString(String beginString) {
        BeginString = beginString;
    }

    public String getMsgType() {
        return MsgType;
    }

    public void setMsgType(String msgType) {
        MsgType = msgType;
    }

    public Integer getMsgSeqNum() {
        return MsgSeqNum;
    }

    public void setMsgSeqNum(Integer msgSeqNum) {
        MsgSeqNum = msgSeqNum;
    }

    public String getSendingTime() {
        return SendingTime;
    }

    public void setSendingTime(String sendingTime) {
        SendingTime = sendingTime;
    }

    public List<String> getSubSymbols() {
        return subSymbols;
    }

    public void setSubSymbols(List<String> subSymbols) {
        this.subSymbols = subSymbols;
    }

    public Map<String, Object> getBooks() {
        return books;
    }

    public void setBooks(Map<String, Object> books) {
        this.books = books;
    }
}
