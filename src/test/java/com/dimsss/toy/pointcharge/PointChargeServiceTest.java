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
        PointChargeDto pointChargeDto = new PointChargeDto();
        Mockito.doThrow(RepositoryException.class).when(temporaryPaymentRepository).save(pointChargeDto);

        assertThrows(RepositoryException.class, () -> {
            pointChargeService.processPointCharge(pointChargeDto, tossPgClient, defaultDiscount, defaultPoint);
        });
    }

    @DisplayName("PG 결제 요청 실패 시 InfraHttpClientException을 발생 시킨다")
    @Test
    void will_throw_InfraHttpClientException_when_IO_Exception() {
        PointChargeDto pointChargeDto = new PointChargeDto(1, PgType.TOSS, PointType.NONE, DiscountType.NONE, "", 10, "");

        when(defaultDiscount.discount(pointChargeDto)).thenReturn(pointChargeDto);
        when(tossPgClient.requestPayment(pointChargeDto)).thenThrow(InfraHttpClientException.class);

        assertThrows(InfraHttpClientException.class, () -> {
            pointChargeService.processPointCharge(pointChargeDto, tossPgClient, defaultDiscount, defaultPoint);
        });
    }

    @DisplayName("결재 내역 저장 실패 시 RepositoryException을 발생 시킨다")
    @Test
    void will_throw_RepositoryException_when_save_fail() throws JSONException, IOException {
        PointChargeDto pointChargeDto = new PointChargeDto(1, PgType.TOSS, PointType.NONE, DiscountType.NONE, "", 10, "");

        PaymentEntity payment = PaymentEntity.builder().build();

        when(defaultDiscount.discount(pointChargeDto)).thenReturn(pointChargeDto);

        Mockito.doReturn(payment).when(tossPgClient).requestPayment(pointChargeDto);
        Mockito.doThrow(RepositoryException.class).when(pointChargeRepository).save(payment, null);

        assertThrows(RepositoryException.class, () -> {
            pointChargeService.processPointCharge(pointChargeDto, tossPgClient, defaultDiscount, defaultPoint);
        });
    }

    @DisplayName("결재 내역 저장 실패 시 RepositoryException을 발생 시킨다")
    @Test
    void should_return_result_when_success() {
        PointChargeDto pointChargeDto = new PointChargeDto(1, PgType.TOSS, PointType.NONE, DiscountType.NONE, "", 10, "");

        PaymentEntity payment = PaymentEntity.builder().build();

        when(defaultDiscount.discount(pointChargeDto)).thenReturn(pointChargeDto);

        Mockito.doReturn(payment).when(tossPgClient).requestPayment(pointChargeDto);
        Mockito.doThrow(RepositoryException.class).when(pointChargeRepository).save(payment, null);

        assertThrows(RepositoryException.class, () -> {
            pointChargeService.processPointCharge(pointChargeDto, tossPgClient, defaultDiscount, defaultPoint);
        });
    }
}