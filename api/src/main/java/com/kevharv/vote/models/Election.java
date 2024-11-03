package com.kevharv.vote.models;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "elections")
public class Election extends BaseEntity {
    private String description;
    private Date startDate;
    private Date endDate;
    
    @ManyToOne
    @JoinColumn(name = "election_position", unique = false)
    private Position position;

    @ManyToOne
    @JoinColumn(name = "election_geo", unique = false)
    private Geography geography;

    @OneToMany
    @JoinColumn(name = "election_candidates", unique = false)
    private List<Politician> candidateList;

    public Election() {}

    public Election(String description, Date startDate, Date endDate, Position position, Geography geography) {
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.position = position;
        this.geography = geography;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Geography getGeography() {
        return geography;
    }

    public void setGeography(Geography geography) {
        this.geography = geography;
    }

    public List<Politician> getCandidateList() {
        return candidateList;
    }

    public void setCandidateList(List<Politician> candidateList) {
        this.candidateList = candidateList;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((description == null) ? 0 : description.hashCode());
        result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
        result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
        result = prime * result + ((position == null) ? 0 : position.hashCode());
        result = prime * result + ((geography == null) ? 0 : geography.hashCode());
        result = prime * result + ((candidateList == null) ? 0 : candidateList.hashCode());
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
        Election other = (Election) obj;
        if (description == null) {
            if (other.description != null)
                return false;
        } else if (!description.equals(other.description))
            return false;
        if (startDate == null) {
            if (other.startDate != null)
                return false;
        } else if (!startDate.equals(other.startDate))
            return false;
        if (endDate == null) {
            if (other.endDate != null)
                return false;
        } else if (!endDate.equals(other.endDate))
            return false;
        if (position == null) {
            if (other.position != null)
                return false;
        } else if (!position.equals(other.position))
            return false;
        if (geography == null) {
            if (other.geography != null)
                return false;
        } else if (!geography.equals(other.geography))
            return false;
        if (candidateList == null) {
            if (other.candidateList != null)
                return false;
        } else if (!candidateList.equals(other.candidateList))
            return false;
        return true;
    }


}
