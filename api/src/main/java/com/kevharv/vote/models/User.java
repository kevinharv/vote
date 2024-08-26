package com.kevharv.vote.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User extends BaseEntity {
    private String userID;
    private String hashedPassword;

    @OneToMany
    @JoinColumn(name = "user_vote_reg")
    private List<VoterRegistration> voterRegistrations;

    public User() {}

    public User(String userID, String hashedPassword) {
        this.userID = userID;
        this.hashedPassword = hashedPassword;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    public List<VoterRegistration> getVoterRegistrations() {
        return voterRegistrations;
    }

    public void setVoterRegistrations(List<VoterRegistration> voterRegistrations) {
        this.voterRegistrations = voterRegistrations;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((userID == null) ? 0 : userID.hashCode());
        result = prime * result + ((hashedPassword == null) ? 0 : hashedPassword.hashCode());
        result = prime * result + ((voterRegistrations == null) ? 0 : voterRegistrations.hashCode());
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
        User other = (User) obj;
        if (userID == null) {
            if (other.userID != null)
                return false;
        } else if (!userID.equals(other.userID))
            return false;
        if (hashedPassword == null) {
            if (other.hashedPassword != null)
                return false;
        } else if (!hashedPassword.equals(other.hashedPassword))
            return false;
        if (voterRegistrations == null) {
            if (other.voterRegistrations != null)
                return false;
        } else if (!voterRegistrations.equals(other.voterRegistrations))
            return false;
        return true;
    }

    
}
