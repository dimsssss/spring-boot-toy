package com.dimsss.toy.pointcharge;

import com.dimsss.toy.lib.NotFoundException;
import com.dimsss.toy.lib.RepositoryException;
import com.dimsss.toy.pointcharge.domain.PointEntity;
import com.dimsss.toy.pointcharge.domain.QPointEntity;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;
import java.util.Optional;

@Repository
public class PointChargeRepository {
    @PersistenceContext
    private final EntityManager entityManager;
    private final JPAQueryFactory jpaQueryFactory;

    PointChargeRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.jpaQueryFactory = new JPAQueryFactory(entityManager);
    }

    public PointEntity findOneBy(int freelancerId) {
        try {
            QPointEntity qPointEntity =  QPointEntity.pointEntity;
            return Optional.ofNullable(this.jpaQueryFactory
                    .selectFrom(qPointEntity)
                    .where(qPointEntity.freelancerId.eq(freelancerId))
                    .orderBy(qPointEntity.id.desc())
                    .limit(1)
                    .fetchOne()).orElseThrow();
        } catch (NoSuchElementException exception) {
            throw new NotFoundException(exception.getMessage());
        }
    }

    @Transactional
    public void save(PaymentEntity payment, PointEntity point) {
        try {
            this.entityManager.persist(payment);
            this.entityManager.persist(point);
        } catch (DataAccessException exception) {
            throw new RepositoryException(exception.getMessage());
        }
    }
}
