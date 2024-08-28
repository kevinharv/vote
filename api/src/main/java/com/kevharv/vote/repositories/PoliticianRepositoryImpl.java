package com.kevharv.vote.repositories;

import com.kevharv.vote.models.Politician;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

public class PoliticianRepositoryImpl {
    
    @PersistenceContext
    EntityManager entityManager;

    private static final String FIND_POL_BY_NAME = "SELECT p FROM Politician p WHERE p.lastName = :name";

    public Politician findByLastName(String lastName) {
        try {
            TypedQuery<Politician> query = entityManager.createQuery(FIND_POL_BY_NAME, Politician.class);
            query.setParameter("name", lastName);

            return query.getSingleResult();
        } finally {
            entityManager.close();
        }
    }
}
