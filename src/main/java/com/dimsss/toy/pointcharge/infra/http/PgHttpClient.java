package com.dimsss.toy.pointcharge.infra.http;

import com.dimsss.toy.lib.NotFoundException;
import com.dimsss.toy.pointcharge.PointChargeDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Component;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Map;

@Component
public class PgHttpClient {
    private ObjectMapper objectMapper = new ObjectMapper();

    public Map<String, String> request(PointChargeDto pointChargeDto, PgType type) throws JSONException, IOException {
        JSONObject obj = new JSONObject();
        obj.put("orderId", pointChargeDto.getOrderId());
        obj.put("amount", pointChargeDto.getAmount());
        obj.put("paymentKey", pointChargeDto.getPaymentKey());

        HttpURLConnection connection = getHttpURLConnection(type);

        OutputStream outputStream = connection.getOutputStream();
        outputStream.write(obj.toString().getBytes(StandardCharsets.UTF_8));

        int code = connection.getResponseCode();
        boolean isSuccess = code == 200;

        if (code >= 400 && code < 500) {
            throw new NotFoundException(connection.getResponseMessage());
        }

        if (code >= 500) {
            throw new RuntimeException();
        }

        InputStream responseStream = isSuccess ? connection.getInputStream() : connection.getErrorStream();

        Reader reader = new InputStreamReader(responseStream, StandardCharsets.UTF_8);

        Map<String, String> result = objectMapper.readValue(reader, Map.class);
        responseStream.close();

        return result;
    }

    private HttpURLConnection getHttpURLConnection(PgType type) throws IOException {
        Base64.Encoder encoder = Base64.getEncoder();
        byte[] encodedBytes = encoder.encode((type.getCode() + ":").getBytes(StandardCharsets.UTF_8));
        String authorizations = "Basic " + new String(encodedBytes);

        URL url = new URL(type.getUrl());
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestProperty("Authorization", authorizations);
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestMethod("POST");
        connection.setDoOutput(true);

        return connection;
    }
}
