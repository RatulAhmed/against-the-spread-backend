package com.atspickem.backend.models;

import javax.persistence.*;

@Entity
@Table(name = "nfl_spread")
public class NflSpread {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int week;
    private String awayTeam;
    private String awaySpread;
    private String homeTeam;
    private String homeSpread;
    private String winner; // H or A or P or Null


    public NflSpread() {
    }

    public NflSpread(int spreadId, int week, String awayTeam, String awaySpread, String homeTeam, String homeSpread) {
        this.id = spreadId;
        this.week = week;
        this.awayTeam = awayTeam;
        this.awaySpread = awaySpread;
        this.homeTeam = homeTeam;
        this.homeSpread = homeSpread;
        this.winner = null;
    }

    public int getSpreadId() {
        return id;
    }

    public void setSpreadId(int spreadId) {
        this.id = spreadId;
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

    @Override
    public String toString() {
        return "NflSpread{" +
                "spreadId=" + id +
                ", week=" + week +
                ", awayTeam='" + awayTeam + '\'' +
                ", awaySpread='" + awaySpread + '\'' +
                ", homeTeam='" + homeTeam + '\'' +
                ", homeSpread='" + homeSpread + '\'' +
                ", winner='" + winner + '\'' +
                '}' + '\n';
    }
}
