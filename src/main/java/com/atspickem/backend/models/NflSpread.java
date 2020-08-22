package com.atspickem.backend.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class NflSpread {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int spreadId;

    private int week;
    private String awayTeam;
    private String awaySpread;
    private String homeTeam;
    private String homeSpread;
    private String winner; // H or A or Null

    public NflSpread() {
    }

    public NflSpread(int spreadId, int week, String awayTeam, String awaySpread, String homeTeam, String homeSpread) {
        this.spreadId = spreadId;
        this.week = week;
        this.awayTeam = awayTeam;
        this.awaySpread = awaySpread;
        this.homeTeam = homeTeam;
        this.homeSpread = homeSpread;
        this.winner = null;
    }

    public int getSpreadId() {
        return spreadId;
    }

    public void setSpreadId(int spreadId) {
        this.spreadId = spreadId;
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

    public String getAwaySpread() {
        return awaySpread;
    }

    public void setAwaySpread(String awaySpread) {
        this.awaySpread = awaySpread;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    public String getHomeSpread() {
        return homeSpread;
    }

    public void setHomeSpread(String homeSpread) {
        this.homeSpread = homeSpread;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }
}
