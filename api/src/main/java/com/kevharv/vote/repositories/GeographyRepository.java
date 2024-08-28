package com.kevharv.vote.repositories;

import org.springframework.data.repository.CrudRepository;

import com.kevharv.vote.models.Geography;

public interface GeographyRepository extends CrudRepository<Geography, Long> {
    Geography findByName(String name);    
}
