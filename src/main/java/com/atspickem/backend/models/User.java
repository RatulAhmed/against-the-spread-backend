package com.atspickem.backend.models;

import javax.persistence.*;

@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String username;
    private String password;
    private String email;
    private boolean active;
    private int score;
    private double pickRatio;


    public User() {
    }

    public User(String username, String password, String email) {
        this.id = 0;
        this.username = username;
        this.password = password;
        this.email = email;
        this.active = true;
        this.score = 0;
        this.pickRatio = 0.0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public float getPickRatio() {
        return pickRatio;
    }

    public void setPickRatio(float pickRatio) {
        this.pickRatio = pickRatio;
    }
}
