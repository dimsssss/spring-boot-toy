package com.dimsss.toy.pointcharge.infra.http;

import com.dimsss.toy.pointcharge.PaymentEntity;
import com.dimsss.toy.pointcharge.PointChargeDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.boot.configurationprocessor.json.JSONException;

import java.io.*;
import java.time.LocalDateTime;
import java.util.Map;

@AllArgsConstructor
public class TossPgClient implements PgClient {
    private final ObjectMapper objectMapper = new ObjectMapper();
    private PgHttpClient pgHttpClient;
    private PgType type;

    public TossPgClient() {}


    private PaymentEntity convert(Map<String,String> result, PointChargeDto pointChargeDto) {
        if (!result.containsKey("code")) {
            return PaymentEntity
                    .builder()
                    .freelancerId(pointChargeDto.getFreelancerId())
                    .balanceAmount(Integer.parseInt(result.get("balanceAmount")))
                    .totalAmount(Integer.parseInt(result.get("totalAmount")))
                    .suppliedAmount(Integer.parseInt(result.get("suppliedAmount")))
                    .vat(Integer.parseInt(result.get("vat")))
                    .orderId(result.get("orderId"))
                    .paymentKey(result.get("paymentKey"))
                    .requestedAt(LocalDateTime.parse(result.get("requestedAt")))
                    .approveAt(LocalDateTime.parse(result.get("approveAt")))
                    .status(result.get("status"))
                    .build();
        }

        throw new IllegalArgumentException(String.valueOf(result));
    }

    @Override
    public PaymentEntity requestPayment(PointChargeDto pointChargeDto) {
        try {
            Map<String, String> result = pgHttpClient.request(pointChargeDto, type);
            return convert(result, pointChargeDto);
        } catch (IOException | JSONException | NullPointerException exception) {
            throw new InfraHttpClientException(exception.getMessage());
        }
    }
}
