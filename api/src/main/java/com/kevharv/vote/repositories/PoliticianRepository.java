package com.kevharv.vote.repositories;

import org.springframework.data.repository.CrudRepository;

import com.kevharv.vote.models.Politician;

public interface PoliticianRepository extends CrudRepository<Politician, Long> {
   Politician findByLastName(String lastName); 
}
