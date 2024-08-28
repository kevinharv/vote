package com.kevharv.vote.repositories;

import com.kevharv.vote.models.Position;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

public class PositionRepositoryImpl {
   
    @PersistenceContext
    EntityManager entityManager;

    private static final String FIND_POS_BY_NAME = "SELECT p FROM Position p WHERE p.name = :name";

    public Position findByName(String name) {
        try {
            TypedQuery<Position> query = entityManager.createQuery(FIND_POS_BY_NAME, Position.class);
            query.setParameter("name", name);

            return query.getSingleResult();
        } finally {
            entityManager.close();
        }
    }
}
