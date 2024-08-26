package com.kevharv.vote.repositories;

import org.springframework.data.repository.CrudRepository;

import com.kevharv.vote.models.VoterRegistration;

public interface VoterRegistrationRepository extends CrudRepository<VoterRegistration, Long> {
    
}
