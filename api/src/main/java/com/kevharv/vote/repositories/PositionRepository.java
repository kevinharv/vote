package com.kevharv.vote.repositories;

import org.springframework.data.repository.CrudRepository;

import com.kevharv.vote.models.Position;

public interface PositionRepository extends CrudRepository<Position, Long> {
    
}
