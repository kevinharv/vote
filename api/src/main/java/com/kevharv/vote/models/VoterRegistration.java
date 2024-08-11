package com.kevharv.vote.models;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "voter_registrations")
public class VoterRegistration extends BaseEntity {
    private boolean isValid;
    private boolean isCitizen;
    private boolean isAgeOfMajority;
    private String prefix;
    private String firstName;
    private String middleName;
    private String lastName;
    private String suffix;
    private Date dateOfBirth;
    private String phoneNumber;
    private String stateIDNumber;
    private String state;
    // Address
    // Party affiliation

    private Date submissionDate;
}
