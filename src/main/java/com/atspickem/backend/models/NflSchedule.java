package com.atspickem.backend.models;

import org.hibernate.annotations.Proxy;

import javax.persistence.*;

// There are performance issues with Proxy but this table will be accessed twice a week max....
@Entity
@Table(name = "nfl_schedule")
@Proxy(lazy = false)
public class NflSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int week;
    private String awayTeam;
    private String homeTeam;

    public NflSchedule() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWeek() {
        return week;
    }

    public void setWeek(int currentWeek) {
        this.week = currentWeek;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(String awayTeam) {
        this.awayTeam = awayTeam;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    @Override
    public String toString() {
        return "NflSchedule{" +
                "id=" + id +
                ", week=" + week +
                ", awayTeam='" + awayTeam + '\'' +
                ", homeTeam='" + homeTeam + '\'' +
                '}';
    }
}
