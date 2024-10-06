package com.dimsss.toy.pointcharge;

import com.dimsss.toy.pointcharge.domain.*;
import com.dimsss.toy.pointcharge.infra.http.CreatePgClient;
import com.dimsss.toy.pointcharge.infra.http.PgClient;
import org.springframework.stereotype.Service;

@Service
public class PointChargeService {
    private final TemporaryPaymentRepository temporaryPaymentRepository;
    private final PointChargeRepository pointChargeRepository;
    private final CreateDiscountPolicy createDiscountPolicy;
    private final CreatePointPolicy createPointPolicy;
    private final CreatePgClient createPgClient;


    PointChargeService(TemporaryPaymentRepository temporaryPaymentRepository, PointChargeRepository pointChargeRepository,
                       CreateDiscountPolicy createDiscountPolicy, CreatePointPolicy createPointPolicy,
                       CreatePgClient createPgClient) {
        this.temporaryPaymentRepository = temporaryPaymentRepository;
        this.pointChargeRepository = pointChargeRepository;
        this.createDiscountPolicy = createDiscountPolicy;
        this.createPointPolicy = createPointPolicy;
        this.createPgClient = createPgClient;
    }

    public void processPointCharge(PointChargeDto pointChargeDto) {
        temporaryPaymentRepository.save(pointChargeDto);

        DiscountPolicy<PointChargeDto, PointChargeDto> discountPolicy = createDiscountPolicy.createDiscountPolicy(pointChargeDto.getDiscountType());

        PgClient<PointChargeDto, PaymentEntity> client = createPgClient.create(pointChargeDto.getPgType());
        PaymentEntity payment = client.requestPayment(discountPolicy.discount(pointChargeDto));

        PointPolicy<PointChargeDto, PointEntity, PointEntity> pointPolicy = createPointPolicy
                .createPointPolicy(pointChargeDto.getPointType());
        PointEntity currentPoint = pointChargeRepository.findOneBy(pointChargeDto.getFreelancerId());
        PointEntity newPoint = pointPolicy.addPoint(pointChargeDto, currentPoint);

        pointChargeRepository.save(payment, newPoint);
    }
}
