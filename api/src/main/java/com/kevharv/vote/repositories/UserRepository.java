package com.kevharv.vote.repositories;

import org.springframework.data.repository.CrudRepository;

import com.kevharv.vote.models.User;

public interface UserRepository extends CrudRepository<User, Long> {
    
}
