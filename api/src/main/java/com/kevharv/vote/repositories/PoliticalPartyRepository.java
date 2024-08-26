package com.kevharv.vote.repositories;

import org.springframework.data.repository.CrudRepository;

import com.kevharv.vote.models.PoliticalParty;

public interface PoliticalPartyRepository extends CrudRepository<PoliticalParty, Long> {
    
}
