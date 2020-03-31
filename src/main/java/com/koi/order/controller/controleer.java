package com.koi.order.controller;

import com.koi.order.entityy.request.MarketDataRequest;
import com.koi.order.entityy.request.OrderSingleRequest;
import com.koi.order.entityy.request.OrderStatusRequest;
import com.koi.order.entityy.response.MarketDataResponse;
import com.koi.order.entityy.response.OrderSingleResponse;
import com.koi.order.entityy.response.OrderStatusResponse;
import com.koi.order.service.JumpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author fitz.bai
 * @Date 2020-03-31 12:39
 */
@RestController("/api/v1")
public class controleer {
    @Autowired
    JumpService jumpService;

    @PostMapping("/quote")
    public OrderStatusResponse quote(@RequestBody MarketDataRequest marketDataRequest) throws Exception {

        return jumpService.marketDataRequest(marketDataRequest);
    }

    @PostMapping("/create")
    public OrderSingleResponse create(@RequestBody OrderSingleRequest request) throws Exception {
        return jumpService.newOrderSingle(request);
    }

    @PostMapping("/get")
    public MarketDataResponse get(OrderStatusRequest request) throws Exception {
        return jumpService.orderStatus(request);
    }
}
