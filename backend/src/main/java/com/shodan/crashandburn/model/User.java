package com.shodan.crashandburn.model;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true)
    private String username;

    @Column(unique = true)
    private String email;

    private String pronouns;

    @Embedded
    private UserCredentials credentials;

    public User(){};

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPronouns() {
        return pronouns;
    }

    public void setPronouns(String pronouns) {
        this.pronouns = pronouns;
    }

    public UserCredentials getCredentials() {
        return credentials;
    }

    public void setCredentials(UserCredentials credentials) {
        this.credentials = credentials;
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder(Long.toString(this.id));
        sb.append(":");
        sb.append(this.username);
        sb.append(":");
        sb.append(this.email);
        sb.append(":");
        sb.append(this.pronouns);
        return sb.toString();
    }
}
