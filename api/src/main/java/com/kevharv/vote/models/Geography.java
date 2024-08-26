package com.kevharv.vote.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

enum GEOGRAPHY_TYPE {
    COUNTRY,
    STATE,
    COUNTY,
    MUNICIPALITY
}

@Entity
@Table(name = "geographies")
public class Geography extends BaseEntity {
    private String name;
    private GEOGRAPHY_TYPE type;

    public Geography() {}

    public Geography(String name, GEOGRAPHY_TYPE type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GEOGRAPHY_TYPE getType() {
        return type;
    }

    public void setType(GEOGRAPHY_TYPE type) {
        this.type = type;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((type == null) ? 0 : type.hashCode());
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
        Geography other = (Geography) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (type != other.type)
            return false;
        return true;
    }    
}
