package com.kevharv.vote.repositories;

import com.kevharv.vote.models.Geography;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

public class GeographyRepositoryImpl {
    @PersistenceContext
    private EntityManager entityManager;

    private static final String FIND_GEO_BY_NAME = "SELECT g FROM Geography g WHERE g.name = :name";

    public Geography findByName(String name) {
        try {
            TypedQuery<Geography> query = entityManager.createQuery(FIND_GEO_BY_NAME, Geography.class);
            query.setParameter("name", name);

            return query.getSingleResult();
        } finally {
            entityManager.close();
        }
    }
}
