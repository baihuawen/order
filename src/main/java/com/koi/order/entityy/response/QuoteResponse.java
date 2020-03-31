package com.koi.order.entityy.response;

import lombok.Data;

/**
 * @Author fitz.bai
 * @Date 2020-03-29 17:11
 */
public class QuoteResponse {
    private String MsgType;
    private String timestamp;
    private String result;

    public String getMsgType() {
        return MsgType;
    }

    public void setMsgType(String msgType) {
        MsgType = msgType;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
