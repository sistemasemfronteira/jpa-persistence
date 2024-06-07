package com.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String email;

    // getters and setters
    // Getter para id
    public int getId() {
        return id;
    }

    // Setter para id
    public void setId(int id) {
        this.id = id;
    }

    // Getter para name
    public String getName() {
        return name;
    }

    // Setter para name
    public void setName(String name) {
        this.name = name;
    }

    // Getter para email
    public String getEmail() {
        return email;
    }

    // Setter para email
    public void setEmail(String email) {
        this.email = email;
    }
}
