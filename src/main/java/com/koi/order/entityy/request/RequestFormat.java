package com.koi.order.entityy.request;

/**
 * @Author fitz.bai
 * @Date 2020-03-29 14:30
 */
public class RequestFormat {
    private String key;
    private String payload;
    private String nonce;
    private String signature;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

    public String getNonce() {
        return nonce;
    }

    public void setNonce(String nonce) {
        this.nonce = nonce;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
