package com.kevharv.vote.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "political_parties")
public class PoliticalParty extends BaseEntity {
    private String name;

    public PoliticalParty() {}

    public PoliticalParty(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
