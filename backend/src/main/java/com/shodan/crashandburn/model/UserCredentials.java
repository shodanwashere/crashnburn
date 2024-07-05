package com.shodan.crashandburn.model;

import jakarta.persistence.Embeddable;

@Embeddable
public class UserCredentials {
    private String passwordHash;

    private String salt;

    public UserCredentials(){};

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
}
