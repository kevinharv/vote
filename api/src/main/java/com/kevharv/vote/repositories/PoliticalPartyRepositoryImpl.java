package com.kevharv.vote.repositories;

import com.kevharv.vote.models.PoliticalParty;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

public class PoliticalPartyRepositoryImpl {

    @PersistenceContext
    private EntityManager entityManager;

    private static final String FIND_PARTY_BY_NAME = "SELECT p FROM PoliticalParty p WHERE p.name = :name";

    public PoliticalParty findByName(String name) {
        try {
            TypedQuery<PoliticalParty> query = entityManager.createQuery(FIND_PARTY_BY_NAME, PoliticalParty.class);
            query.setParameter("name", name);

            return query.getSingleResult();
        } finally {
            entityManager.close();
        }
    }
}
