package com.kevharv.vote.repositories;

import com.kevharv.vote.models.PoliticalParty;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

public class PoliticalPartyRepositoryImpl implements CustomPoliticalPartyRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public PoliticalParty getPartyByName(String name) {
        TypedQuery<PoliticalParty> query = entityManager.createQuery("FROM political_parties WHERE name = " + name, PoliticalParty.class);
        return query.getSingleResult();
    }
}
