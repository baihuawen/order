package com.koi.order.entityy.response;

import lombok.Data;

import java.util.Map;

/**
 * @Author fitz.bai
 * @Date 2020-03-29 17:12
 */
@Data
public class OrderStatusResponse {
    private String BeginString;
    private String MsgType;
    private Integer MsgSeqNum;
    private String SendingTime;
    private Map<String, Execs> execs;

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

    public Map<String, Execs> getExecs() {
        return execs;
    }

    public void setExecs(Map<String, Execs> execs) {
        this.execs = execs;
    }
}
