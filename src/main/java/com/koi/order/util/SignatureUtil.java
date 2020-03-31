package com.koi.order.util;

import com.google.gson.Gson;
import com.koi.order.entityy.request.RequestFormat;
import org.apache.commons.codec.binary.Hex;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

/**
 * @Author fitz.bai
 * @Date 2020-03-29 12:16
 */
public class SignatureUtil {

    public final static Gson GSON = new Gson();

    static String getNonce() {
        /**
         * different between java and python
         */
        return System.currentTimeMillis() / 1000 + ".0";
    }

    public static <T> RequestFormat makePostBody(T payload, String key, String secret) throws Exception {
        /**
         * warning：You have two different strings （java Gson.toJson() & python json.dumps()）- Java doesn't have space after
         *
         * example: java: {"Symbol":"UAT","Side":"1"}
         * but    python: {"Symbol": "UAT", "Side": "1"}
         *
         * so we need to change the java json string (with replace)
         */
        String strPayLoad = Base64.getEncoder()
                .encodeToString(GSON.toJson(payload)
                        .replaceAll(":", ": ")
                        .replaceAll(",", ", ").getBytes("UTF-8"));

        String timestamp = getNonce();
        String message = key + strPayLoad + timestamp;
        String signature = HMAC_SHA384_encode(secret, message);
        RequestFormat re = new RequestFormat();
        re.setKey(key);
        re.setPayload(strPayLoad);
        re.setNonce(timestamp);
        re.setSignature(signature);
        return re;
    }

    /**
     * sha384编码
     *
     * @param key
     * @param message
     * @return
     * @throws Exception
     */
    public static String HMAC_SHA384_encode(String key, String message) throws Exception {
        SecretKeySpec keySpec = new SecretKeySpec(
                key.getBytes(),
                "Hmacsha384");

        Mac mac = Mac.getInstance("Hmacsha384");
        mac.init(keySpec);
        byte[] rawHmac = mac.doFinal(message.getBytes());

        return Hex.encodeHexString(rawHmac);
    }
}
