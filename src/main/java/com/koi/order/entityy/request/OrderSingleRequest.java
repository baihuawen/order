package com.koi.order.entityy.request;

/**
 * @Author fitz.bai
 * @Date 2020-03-29 15:53
 */
public class OrderSingleRequest {
    private String Symbol;
    private String ClOrdID;
    private String OrdType;
    private String TimeInForce;
    private String Side;
    private Double Price;
    private Integer OrderQty;
    private String EndUserID;
    private Integer Managed;

    public String getSymbol() {
        return Symbol;
    }

    public void setSymbol(String symbol) {
        Symbol = symbol;
    }

    public String getClOrdID() {
        return ClOrdID;
    }

    public void setClOrdID(String clOrdID) {
        ClOrdID = clOrdID;
    }

    public String getOrdType() {
        return OrdType;
    }

    public void setOrdType(String ordType) {
        OrdType = ordType;
    }

    public String getTimeInForce() {
        return TimeInForce;
    }

    public void setTimeInForce(String timeInForce) {
        TimeInForce = timeInForce;
    }

    public String getSide() {
        return Side;
    }

    public void setSide(String side) {
        Side = side;
    }

    public Double getPrice() {
        return Price;
    }

    public void setPrice(Double price) {
        Price = price;
    }

    public Integer getOrderQty() {
        return OrderQty;
    }

    public void setOrderQty(Integer orderQty) {
        OrderQty = orderQty;
    }

    public String getEndUserID() {
        return EndUserID;
    }

    public void setEndUserID(String endUserID) {
        EndUserID = endUserID;
    }

    public Integer getManaged() {
        return Managed;
    }

    public void setManaged(Integer managed) {
        Managed = managed;
    }
}
