package com.koi.order.entityy.response;

import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * @Author fitz.bai
 * @Date 2020-03-30 17:21
 */
@Data
public class MarketDataResponse {
    private String BeginString;
    private String MsgType;
    private Integer MsgSeqNum;
    private String SendingTime;
    private List<String> subSymbols;
    private Map<String, Object> books;
}
