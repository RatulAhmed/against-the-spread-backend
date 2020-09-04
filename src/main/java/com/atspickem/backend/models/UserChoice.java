package com.atspickem.backend.models;

import javax.persistence.*;

@Entity
@Table(name="user_choice")
public class UserChoice {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    @JoinColumn(name = "user_id")
    private int userId;
    @JoinColumn(name = "spread_id")
    private int spreadId;
    private char choice;

    public UserChoice() {
    }

    public UserChoice(String id, int userId, int spreadId, char choice) {
        this.id = id;
        this.userId = userId;
        this.spreadId = spreadId;
        this.choice = choice;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getSpreadId() {
        return spreadId;
    }

    public void setSpreadId(int spreadId) {
        this.spreadId = spreadId;
    }

    public char getChoice() {
        return choice;
    }

    public void setChoice(char choice) {
        this.choice = choice;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Id
    public String getId() {
        return id;
    }
}
