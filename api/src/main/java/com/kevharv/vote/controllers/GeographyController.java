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

import com.kevharv.vote.exceptions.NotFoundException;
import com.kevharv.vote.models.Geography;
import com.kevharv.vote.repositories.GeographyRepository;
import com.kevharv.vote.utilities.ObjectManipulation;

@RestController
public class GeographyController {
    @Autowired
    private final GeographyRepository geographyRepository;
    
    GeographyController(GeographyRepository geographyRepository) {
        this.geographyRepository = geographyRepository;
    }

    @GetMapping("/geographies")
    public List<Geography> getGeographies() {
        List<Geography> geographies = new ArrayList<Geography>();
        geographyRepository.findAll().forEach(geography -> geographies.add(geography));
        return geographies;
    }

    @GetMapping("/geographies/{id}")
    public Geography getGeographyByID(@PathVariable Long id) {
        return geographyRepository.findById(id).orElseThrow(() -> new NotFoundException(id, "geography"));
    }

    @PostMapping("/geographies")
    public Geography createParty(@RequestBody Geography geography) {
        return geographyRepository.save(geography);
    }

    @PutMapping("/geographies/{id}")
    public Geography updateParty(@RequestBody Geography geography, @PathVariable Long id) {
        Geography existingGeography = geographyRepository.findById(id).orElseThrow(() -> new NotFoundException(id, "geography"));
        ObjectManipulation.copyNonNullProperties(geography, existingGeography);
        return geographyRepository.save(geography);
    }

    @DeleteMapping("/geographies/{id}")
    public ResponseEntity<?> deleteGroup(@PathVariable Long id) {
        geographyRepository.findById(id).orElseThrow(() -> new NotFoundException(id, "geography"));
        geographyRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
