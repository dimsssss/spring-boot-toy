package com.dimsss.toy;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class DatabaseCleaner {
    @Autowired
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    void clear() {
        entityManager.createNativeQuery("TRUNCATE TABLE points;").executeUpdate();
        entityManager.createNativeQuery("TRUNCATE TABLE freelancer_view_log;").executeUpdate();
    }
}
