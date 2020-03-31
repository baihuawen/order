package com.koi.order.entityy.request;

import java.util.List;

/**
 * @Author fitz.bai
 * @Date 2020-03-29 15:59
 */
public class OrderStatusRequest {
    private List<String> lstOrderIds;

    public List<String> getLstOrderIds() {
        return lstOrderIds;
    }

    public void setLstOrderIds(List<String> lstOrderIds) {
        this.lstOrderIds = lstOrderIds;
    }
}
