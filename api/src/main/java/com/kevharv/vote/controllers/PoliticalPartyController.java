package com.kevharv.vote.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kevharv.vote.repositories.PoliticalPartyRepository;
import com.kevharv.vote.exceptions.NotFoundException;
import com.kevharv.vote.models.PoliticalParty;
import com.kevharv.vote.utilities.ObjectManipulation;

@RestController
public class PoliticalPartyController {
    @Autowired
    private final PoliticalPartyRepository politicalPartyRepository;
    
    PoliticalPartyController(PoliticalPartyRepository politicalPartyRepository) {
        this.politicalPartyRepository = politicalPartyRepository;
    }

    @GetMapping("/parties")
    public List<PoliticalParty> getParties() {
        List<PoliticalParty> parties = new ArrayList<PoliticalParty>();
        politicalPartyRepository.findAll().forEach(party -> parties.add(party));
        return parties;
    }

    @GetMapping("/parties/count")
    public long getPartyCount() {
        return politicalPartyRepository.count();
    }

    @GetMapping("/parties/{id}")
    public PoliticalParty getPartyByID(@PathVariable Long id) {
        return politicalPartyRepository.findById(id).orElseThrow(() -> new NotFoundException(id, "party"));
    }

    @PostMapping("/parties")
    public PoliticalParty createParty(@RequestBody PoliticalParty party) {
        return politicalPartyRepository.save(party);
    }

    @PutMapping("/parties/{id}")
    public PoliticalParty updateParty(@RequestBody PoliticalParty party, @PathVariable Long id) {
        PoliticalParty existingParty = politicalPartyRepository.findById(id).orElseThrow(() -> new NotFoundException(id, "party"));
        ObjectManipulation.copyNonNullProperties(party, existingParty);
        return politicalPartyRepository.save(party);
    }

    @DeleteMapping("/parties/{id}")
    public ResponseEntity<?> deleteGroup(@PathVariable Long id) {
        politicalPartyRepository.findById(id).orElseThrow(() -> new NotFoundException(id, "party"));
        politicalPartyRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
