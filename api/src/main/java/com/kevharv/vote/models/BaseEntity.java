package com.kevharv.vote.models;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PostUpdate;
import jakarta.persistence.PrePersist;

@MappedSuperclass
public abstract class BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date dateCreated;
    private Date lastUpdated;

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateCreated() {
        return this.dateCreated;
    }

    @PrePersist
    protected void onCreate() {
        this.dateCreated = new Date();
    }

    public Date getLastUpdated() {
        return this.lastUpdated;
    }

    @PostUpdate
    protected void onUpdate() {
        this.lastUpdated = new Date();
    }
}