package com.kevharv.vote.repositories;

import org.springframework.data.repository.CrudRepository;

import com.kevharv.vote.models.Address;

public interface AddressRepository extends CrudRepository<Address, Long> {
    
}
