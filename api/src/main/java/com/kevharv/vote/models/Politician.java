package com.kevharv.vote.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "politicians")
public class Politician extends BaseEntity {
    private String firstName;
    private String lastName;
    private String displayName;

    @ManyToOne
    @JoinColumn(name = "politican_party", unique = false)
    private PoliticalParty party;

    @ManyToOne
    @JoinColumn(name = "politican_geography", unique = false)
    private Geography homeGeography;

    public Politician() {}

    public Politician(String firstName, String lastName, PoliticalParty party, Geography homeGeography) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.displayName = lastName + ", " + firstName;
        this.party = party;
        this.homeGeography = homeGeography;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public PoliticalParty getParty() {
        return party;
    }

    public void setParty(PoliticalParty party) {
        this.party = party;
    }

    public Geography getHomeGeography() {
        return homeGeography;
    }

    public void setHomeGeography(Geography homeGeography) {
        this.homeGeography = homeGeography;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
        result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
        result = prime * result + ((displayName == null) ? 0 : displayName.hashCode());
        result = prime * result + ((party == null) ? 0 : party.hashCode());
        result = prime * result + ((homeGeography == null) ? 0 : homeGeography.hashCode());
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
        Politician other = (Politician) obj;
        if (firstName == null) {
            if (other.firstName != null)
                return false;
        } else if (!firstName.equals(other.firstName))
            return false;
        if (lastName == null) {
            if (other.lastName != null)
                return false;
        } else if (!lastName.equals(other.lastName))
            return false;
        if (displayName == null) {
            if (other.displayName != null)
                return false;
        } else if (!displayName.equals(other.displayName))
            return false;
        if (party == null) {
            if (other.party != null)
                return false;
        } else if (!party.equals(other.party))
            return false;
        if (homeGeography == null) {
            if (other.homeGeography != null)
                return false;
        } else if (!homeGeography.equals(other.homeGeography))
            return false;
        return true;
    }

}
