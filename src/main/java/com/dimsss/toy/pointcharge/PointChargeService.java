package com.dimsss.toy.pointcharge;

import com.dimsss.toy.pointcharge.domain.*;
import com.dimsss.toy.pointcharge.infra.http.PgClient;
import org.springframework.stereotype.Service;

@Service
public class PointChargeService {
    private final TemporaryPaymentRepository temporaryPaymentRepository;
    private final PointChargeRepository pointChargeRepository;


    PointChargeService(TemporaryPaymentRepository temporaryPaymentRepository, PointChargeRepository pointChargeRepository) {
        this.temporaryPaymentRepository = temporaryPaymentRepository;
        this.pointChargeRepository = pointChargeRepository;
    }

    public void processPointCharge(PointChargeDto pointChargeDto, PgClient pgClient, DiscountPolicy discountPolicy, PointPolicy pointPolicy) {
        temporaryPaymentRepository.save(pointChargeDto);

        PaymentEntity payment = pgClient.requestPayment(discountPolicy.discount(pointChargeDto));
        PointEntity currentPoint = pointChargeRepository.findOneBy(pointChargeDto.getFreelancerId());
        PointEntity newPoint = pointPolicy.addPoint(pointChargeDto, currentPoint);

        pointChargeRepository.save(payment, newPoint);
    }
}
