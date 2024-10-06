package com.dimsss.toy.pointcharge;

import com.dimsss.toy.lib.RepositoryException;
import com.dimsss.toy.pointcharge.domain.*;
import com.dimsss.toy.pointcharge.infra.http.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.configurationprocessor.json.JSONException;


import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PointChargeServiceTest {
    @InjectMocks
    private PointChargeService pointChargeService;

    @Mock
    private PointChargeRepository pointChargeRepository;

    @Mock
    private TemporaryPaymentRepository temporaryPaymentRepository;

    @Mock
    private CreatePgClient createPgClient;

    @Spy
    private CreateDiscountPolicy createDiscountPolicy;

    @Spy
    private CreatePointPolicy createPointPolicy;

    @Mock
    private PgHttpClient pgHttpClient;

    @Mock
    private DefaultDiscount defaultDiscount;

    @Mock
    private DefaultPoint defaultPoint;

    @Mock
    private TossPgClient tossPgClient;


    @BeforeEach
    void setup() {
    }

    @DisplayName("임시 주문 데이터 저장 실패 시 RepositoryException을 발생 시킨다")
    @Test
    void will_throw_repository_exception_when_fail() {
        PointChargeDto pointChargeDto = PointChargeDto.builder().build();
        Mockito.doThrow(RepositoryException.class).when(temporaryPaymentRepository).save(pointChargeDto);

        assertThrows(RepositoryException.class, () -> {
            pointChargeService.processPointCharge(pointChargeDto);
        });
    }

    @DisplayName("PG 결제 요청 실패 시 InfraHttpClientException을 발생 시킨다")
    @Test
    void will_throw_InfraHttpClientException_when_IO_Exception() {
        PointChargeDto pointChargeDto = PointChargeDto.builder().pgType(PgType.TOSS).discountType(DiscountType.NONE).amount(10).build();

        when(createDiscountPolicy.createDiscountPolicy(pointChargeDto.getDiscountType())).thenReturn(defaultDiscount);
        when(defaultDiscount.discount(pointChargeDto)).thenReturn(pointChargeDto);
        when(createPgClient.create(pointChargeDto.getPgType())).thenReturn(tossPgClient);
        when(tossPgClient.requestPayment(pointChargeDto)).thenThrow(InfraHttpClientException.class);

        assertThrows(InfraHttpClientException.class, () -> {
            pointChargeService.processPointCharge(pointChargeDto);
        });
    }

    @DisplayName("결재 내역 저장 실패 시 RepositoryException을 발생 시킨다")
    @Test
    void will_throw_RepositoryException_when_save_fail() throws JSONException, IOException {
        PointChargeDto pointChargeDto = PointChargeDto.builder().pgType(PgType.TOSS).discountType(DiscountType.NONE).build();

//        Map<String, String> tmp = Map.of("balanceAmount", "10", "totalAmount", "10",
//                                        "suppliedAmount", "1", "vat", "1",
//                                        "orderId", "test", "paymentKey", "test",
//                                        "requestedAt", "2022-06-08T15:40:09", "approveAt", "2022-06-08T15:40:09",
//                                        "status", "DONE");
        PaymentEntity payment = PaymentEntity.builder().build();

        when(createDiscountPolicy.createDiscountPolicy(pointChargeDto.getDiscountType())).thenReturn(defaultDiscount);
        when(defaultDiscount.discount(pointChargeDto)).thenReturn(pointChargeDto);
        when(createPointPolicy.createPointPolicy(pointChargeDto.getPointType())).thenReturn(defaultPoint);
        when(createPgClient.create(pointChargeDto.getPgType())).thenReturn(tossPgClient);

        Mockito.doReturn(payment).when(tossPgClient).requestPayment(pointChargeDto);
        Mockito.doThrow(RepositoryException.class).when(pointChargeRepository).save(payment, null);

        assertThrows(RepositoryException.class, () -> {
            pointChargeService.processPointCharge(pointChargeDto);
        });
    }

    @DisplayName("결재 내역 저장 실패 시 RepositoryException을 발생 시킨다")
    @Test
    void should_return_result_when_success() {
        PointChargeDto pointChargeDto = PointChargeDto.builder().pgType(PgType.TOSS).discountType(DiscountType.NONE).build();

//        Map<String, String> tmp = Map.of("balanceAmount", "10", "totalAmount", "10",
//                                        "suppliedAmount", "1", "vat", "1",
//                                        "orderId", "test", "paymentKey", "test",
//                                        "requestedAt", "2022-06-08T15:40:09", "approveAt", "2022-06-08T15:40:09",
//                                        "status", "DONE");
        PaymentEntity payment = PaymentEntity.builder().build();

        when(createDiscountPolicy.createDiscountPolicy(pointChargeDto.getDiscountType())).thenReturn(defaultDiscount);
        when(defaultDiscount.discount(pointChargeDto)).thenReturn(pointChargeDto);
        when(createPointPolicy.createPointPolicy(pointChargeDto.getPointType())).thenReturn(defaultPoint);
        when(createPgClient.create(pointChargeDto.getPgType())).thenReturn(tossPgClient);

        Mockito.doReturn(payment).when(tossPgClient).requestPayment(pointChargeDto);
        Mockito.doThrow(RepositoryException.class).when(pointChargeRepository).save(payment, null);

        assertThrows(RepositoryException.class, () -> {
            pointChargeService.processPointCharge(pointChargeDto);
        });
    }


}