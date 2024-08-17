package com.kevharv.vote.models;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
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

    @OneToOne
    @JoinColumn(name="voter_reg_addr", unique=true, nullable=false, updatable=false)
    private Address address;

    @OneToOne
    private PoliticalParty partyAffiliation;

    private Date submissionDate;

    public VoterRegistration() {}

    public VoterRegistration(String stateIDNumber) {
        this.stateIDNumber = stateIDNumber;
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean isValid) {
        this.isValid = isValid;
    }

    public boolean isCitizen() {
        return isCitizen;
    }

    public void setCitizen(boolean isCitizen) {
        this.isCitizen = isCitizen;
    }

    public boolean isAgeOfMajority() {
        return isAgeOfMajority;
    }

    public void setAgeOfMajority(boolean isAgeOfMajority) {
        this.isAgeOfMajority = isAgeOfMajority;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getStateIDNumber() {
        return stateIDNumber;
    }

    public void setStateIDNumber(String stateIDNumber) {
        this.stateIDNumber = stateIDNumber;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public PoliticalParty getPartyAffiliation() {
        return partyAffiliation;
    }

    public void setPartyAffiliation(PoliticalParty partyAffiliation) {
        this.partyAffiliation = partyAffiliation;
    }

    public Date getSubmissionDate() {
        return submissionDate;
    }

    public void setSubmissionDate(Date submissionDate) {
        this.submissionDate = submissionDate;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (isValid ? 1231 : 1237);
        result = prime * result + (isCitizen ? 1231 : 1237);
        result = prime * result + (isAgeOfMajority ? 1231 : 1237);
        result = prime * result + ((prefix == null) ? 0 : prefix.hashCode());
        result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
        result = prime * result + ((middleName == null) ? 0 : middleName.hashCode());
        result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
        result = prime * result + ((suffix == null) ? 0 : suffix.hashCode());
        result = prime * result + ((dateOfBirth == null) ? 0 : dateOfBirth.hashCode());
        result = prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
        result = prime * result + ((stateIDNumber == null) ? 0 : stateIDNumber.hashCode());
        result = prime * result + ((state == null) ? 0 : state.hashCode());
        result = prime * result + ((address == null) ? 0 : address.hashCode());
        result = prime * result + ((partyAffiliation == null) ? 0 : partyAffiliation.hashCode());
        result = prime * result + ((submissionDate == null) ? 0 : submissionDate.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        VoterRegistration other = (VoterRegistration) obj;
        if (isValid != other.isValid)
            return false;
        if (isCitizen != other.isCitizen)
            return false;
        if (isAgeOfMajority != other.isAgeOfMajority)
            return false;
        if (prefix == null) {
            if (other.prefix != null)
                return false;
        } else if (!prefix.equals(other.prefix))
            return false;
        if (firstName == null) {
            if (other.firstName != null)
                return false;
        } else if (!firstName.equals(other.firstName))
            return false;
        if (middleName == null) {
            if (other.middleName != null)
                return false;
        } else if (!middleName.equals(other.middleName))
            return false;
        if (lastName == null) {
            if (other.lastName != null)
                return false;
        } else if (!lastName.equals(other.lastName))
            return false;
        if (suffix == null) {
            if (other.suffix != null)
                return false;
        } else if (!suffix.equals(other.suffix))
            return false;
        if (dateOfBirth == null) {
            if (other.dateOfBirth != null)
                return false;
        } else if (!dateOfBirth.equals(other.dateOfBirth))
            return false;
        if (phoneNumber == null) {
            if (other.phoneNumber != null)
                return false;
        } else if (!phoneNumber.equals(other.phoneNumber))
            return false;
        if (stateIDNumber == null) {
            if (other.stateIDNumber != null)
                return false;
        } else if (!stateIDNumber.equals(other.stateIDNumber))
            return false;
        if (state == null) {
            if (other.state != null)
                return false;
        } else if (!state.equals(other.state))
            return false;
        if (address == null) {
            if (other.address != null)
                return false;
        } else if (!address.equals(other.address))
            return false;
        if (partyAffiliation == null) {
            if (other.partyAffiliation != null)
                return false;
        } else if (!partyAffiliation.equals(other.partyAffiliation))
            return false;
        if (submissionDate == null) {
            if (other.submissionDate != null)
                return false;
        } else if (!submissionDate.equals(other.submissionDate))
            return false;
        return true;
    }

    
}
