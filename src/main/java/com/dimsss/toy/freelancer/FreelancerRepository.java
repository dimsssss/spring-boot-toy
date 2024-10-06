package com.dimsss.toy.freelancer;

import com.dimsss.toy.freelancer.controller.FreelancerDto;
import com.dimsss.toy.lib.RepositoryException;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Repository
public class FreelancerRepository {
    private final JPAQueryFactory queryFactory;
    @PersistenceContext
    private final EntityManager entityManager;

    FreelancerRepository(EntityManager entityManager) {
        this.queryFactory = new JPAQueryFactory(entityManager);
        this.entityManager = entityManager;
    }

    private OrderSpecifier<?> getOrderSpecifier(QFreelancerEntity freelancer, FreelancerDto freelancerDto) {
        return switch (freelancerDto.getSort()) {
            case NAME_ASC -> freelancer.name.asc();
            case NAME_DESC -> freelancer.name.desc();
            case VIEW_COUNT_ASC -> freelancer.viewCount.asc();
            case VIEW_COUNT_DESC -> freelancer.viewCount.desc();
            case CREATED_AT_ASC -> freelancer.createdAt.asc();
            case CREATED_AT_DESC -> freelancer.createdAt.desc();
        };
    }

    public List<FreelancerResponse> getList(FreelancerDto freelancerDto) {
        try {
            QFreelancerEntity freelancer = QFreelancerEntity.freelancerEntity;
            OrderSpecifier<?> orderSpecifier = getOrderSpecifier(freelancer, freelancerDto);
            return this.queryFactory
                    .select(freelancer.id,
                            freelancer.name,
                            freelancer.createdAt,
                            freelancer.viewCount)
                    .from(freelancer)
                    .where(freelancer.id.goe(freelancerDto.getLastId()))
                    .orderBy(orderSpecifier)
                    .limit(freelancerDto.getLimit())
                    .fetch()
                    .stream()
                    .map(tuple -> new FreelancerResponse(
                            Optional.ofNullable(tuple.get(QFreelancerEntity.freelancerEntity.id)).orElseThrow(),
                            tuple.get(QFreelancerEntity.freelancerEntity.name),
                            Optional.ofNullable(tuple.get(QFreelancerEntity.freelancerEntity.viewCount)).orElse(0),
                            tuple.get(QFreelancerEntity.freelancerEntity.createdAt))).toList();
        } catch (DataAccessException exception) {
            throw new RepositoryException(exception.getMessage());
        }
    }

    public void existUser(int userId) {
        try {
            QFreelancerEntity freelancer = QFreelancerEntity.freelancerEntity;
            Optional.ofNullable(
                    this.queryFactory
                    .select(freelancer.id)
                    .from(freelancer)
                    .where(freelancer.id.eq(userId))
                    .fetchOne())
                    .orElseThrow();
        } catch (DataAccessException exception) {
            throw new RepositoryException(exception.getMessage());
        }
    }

    @Transactional
    public FreelancerViewLogEntity createViewLog(int freelancerId) {
        try {
            FreelancerViewLogEntity log = FreelancerViewLogEntity.builder().freelancerId(freelancerId).build();
            this.entityManager.persist(log);
            return log;
        } catch (DataAccessException exception) {
            throw new RepositoryException(exception.getMessage());
        }
    }

    @Transactional
    public int batch(int freelancerId) {
        try {
            QFreelancerViewLogEntity qFreelancerViewLog = QFreelancerViewLogEntity.freelancerViewLogEntity;
            QFreelancerEntity qFreelancerEntity = QFreelancerEntity.freelancerEntity;

            int count = Math.toIntExact(Optional.ofNullable(
                this.queryFactory
                    .select(qFreelancerViewLog.count())
                    .from(qFreelancerViewLog)
                    .where(qFreelancerViewLog.freelancerId.eq(freelancerId))
                    .fetchOne()).orElse(0L));

            this.queryFactory
                .delete(qFreelancerViewLog)
                .where(qFreelancerViewLog.freelancerId.eq(freelancerId))
                .execute();

            FreelancerEntity freelancerEntity = this.entityManager.find(FreelancerEntity.class, freelancerId);

            this.queryFactory
                    .update(qFreelancerEntity)
                    .set(qFreelancerEntity.viewCount, freelancerEntity.getViewCount() + count)
                    .where(qFreelancerEntity.id.eq(freelancerId))
                    .execute();

            return count;
        } catch (DataAccessException exception) {
            exception.printStackTrace();
            throw new RepositoryException(exception.getMessage());
        }
    }
}
