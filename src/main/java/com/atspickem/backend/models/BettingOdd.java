package com.atspickem.backend.models;

public class BettingOdd {
    private String firstTeam;
    private String secondTeam;
    private String firstSpread;
    private String secondSpread;

    public BettingOdd() {
    }

    public BettingOdd(BettingOdd obj) {
        this.firstTeam = obj.getFirstTeam();
        this.secondTeam = obj.getSecondTeam();
        this.firstSpread = obj.getFirstSpread();
        this.secondSpread = obj.getSecondSpread();
    }

    public String getFirstTeam() {
        return firstTeam;
    }

    public void setFirstTeam(String firstTeam) {
        this.firstTeam = firstTeam;
    }

    public String getSecondTeam() {
        return secondTeam;
    }

    public void setSecondTeam(String secondTeam) {
        this.secondTeam = secondTeam;
    }

    public String getFirstSpread() {
        return firstSpread;
    }

    public void setFirstSpread(String firstSpread) {
        this.firstSpread = firstSpread;
    }

    public String getSecondSpread() {
        return secondSpread;
    }

    public void setSecondSpread(String secondSpread) {
        this.secondSpread = secondSpread;
    }

    @Override
    public String toString() {
        return "BettingOdd{" +
                "firstTeam='" + firstTeam + '\'' +
                ", secondTeam='" + secondTeam + '\'' +
                ", firstSpread='" + firstSpread + '\'' +
                ", secondSpread='" + secondSpread + '\'' +
                '}';
    }
}
