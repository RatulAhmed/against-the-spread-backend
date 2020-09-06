package com.atspickem.backend.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name="user_choice")
public class UserChoice {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private int id;
    //    @ManyToOne
//    @JoinColumn(name = "user_id")
    private int userId;
    //    @ManyToOne
//    @JoinColumn(name = "spread_id")
    private int spreadId;
    private String choice;

    public UserChoice() {
    }

    public UserChoice(int id, int userId, int spreadId, String choice) {
        this.id = id;
        this.userId = userId;
        this.spreadId = spreadId;
        this.choice = choice;
    }

    public UserChoice(int userId, int spreadId, String choice) {
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

    public String getChoice() {
        return choice;
    }

    public void setChoice(String choice) {
        this.choice = choice;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Id
    public int getId() {
        return id;
    }
}
