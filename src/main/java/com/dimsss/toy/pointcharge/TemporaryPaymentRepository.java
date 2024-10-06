package com.dimsss.toy.pointcharge;

import com.dimsss.toy.lib.RepositoryException;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class TemporaryPaymentRepository {
    private final JPAQueryFactory queryFactory;
    @PersistenceContext
    private final EntityManager entityManager;

    TemporaryPaymentRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.queryFactory = new JPAQueryFactory(entityManager);
    }

    @Transactional
    public TemporaryPaymentEntity save(PointChargeDto pointChargeDto) {
        try {
            TemporaryPaymentEntity temporaryPaymentEntity = TemporaryPaymentEntity.builder()
                    .orderId(pointChargeDto.getOrderId())
                    .paymentKey(pointChargeDto.getPaymentKey())
                    .amount(pointChargeDto.getAmount())
                    .build();
            this.entityManager.persist(temporaryPaymentEntity);
            return temporaryPaymentEntity;
        } catch (DataAccessException exception) {
            throw new RepositoryException(exception.getMessage());
        }
    }
}
