package com.kevharv.vote.repositories;

import org.springframework.data.repository.CrudRepository;

import com.kevharv.vote.models.Election;

public interface ElectionRepository extends CrudRepository<Election, Long> {
    
}
