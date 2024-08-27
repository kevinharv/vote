package com.kevharv.vote.repositories;

import com.kevharv.vote.models.PoliticalParty;

public interface CustomPoliticalPartyRepository {
    PoliticalParty getPartyByName(String name);
}
