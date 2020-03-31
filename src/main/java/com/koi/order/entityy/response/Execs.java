package com.koi.order.entityy.response;

/**
 * @Author fitz.bai
 * @Date 2020-03-29 17:18
 */
@Data
public class Execs {
    private String BeginString;
    private String MsgType;
    private Integer MsgSeqNum;
    private String SendingTime;
    private String OrigSendingTime;
    private String ClOrdID;
    private String OrderID;
    private String ExecID;
    private String OrdStatus;
    private String ExecType;
    private String ExecTransType;
    private String Symbol;
    private String Side;
    private Double OrderQty;
    private String OrdType;
    private Double Price;
    private String TransactTime;
    private String ClientID;
    private Double LeavesQty;
    private Double CumQty;
    private Double AvgPx;
    private String BookType;
    private String Account;

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

    public String getOrigSendingTime() {
        return OrigSendingTime;
    }

    public void setOrigSendingTime(String origSendingTime) {
        OrigSendingTime = origSendingTime;
    }

    public String getClOrdID() {
        return ClOrdID;
    }

    public void setClOrdID(String clOrdID) {
        ClOrdID = clOrdID;
    }

    public String getOrderID() {
        return OrderID;
    }

    public void setOrderID(String orderID) {
        OrderID = orderID;
    }

    public String getExecID() {
        return ExecID;
    }

    public void setExecID(String execID) {
        ExecID = execID;
    }

    public String getOrdStatus() {
        return OrdStatus;
    }

    public void setOrdStatus(String ordStatus) {
        OrdStatus = ordStatus;
    }

    public String getExecType() {
        return ExecType;
    }

    public void setExecType(String execType) {
        ExecType = execType;
    }

    public String getExecTransType() {
        return ExecTransType;
    }

    public void setExecTransType(String execTransType) {
        ExecTransType = execTransType;
    }

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

    public String getOrdType() {
        return OrdType;
    }

    public void setOrdType(String ordType) {
        OrdType = ordType;
    }

    public String getTransactTime() {
        return TransactTime;
    }

    public void setTransactTime(String transactTime) {
        TransactTime = transactTime;
    }

    public String getClientID() {
        return ClientID;
    }

    public void setClientID(String clientID) {
        ClientID = clientID;
    }

    public String getBookType() {
        return BookType;
    }

    public void setBookType(String bookType) {
        BookType = bookType;
    }

    public String getAccount() {
        return Account;
    }

    public void setAccount(String account) {
        Account = account;
    }

    public Double getOrderQty() {
        return OrderQty;
    }

    public void setOrderQty(Double orderQty) {
        OrderQty = orderQty;
    }

    public Double getPrice() {
        return Price;
    }

    public void setPrice(Double price) {
        Price = price;
    }

    public Double getLeavesQty() {
        return LeavesQty;
    }

    public void setLeavesQty(Double leavesQty) {
        LeavesQty = leavesQty;
    }

    public Double getCumQty() {
        return CumQty;
    }

    public void setCumQty(Double cumQty) {
        CumQty = cumQty;
    }

    public Double getAvgPx() {
        return AvgPx;
    }

    public void setAvgPx(Double avgPx) {
        AvgPx = avgPx;
    }
}
