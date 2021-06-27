package com.atspickem.backend.models;

public class SpreadChoiceRequest {

    private int userId;
    private int spreadId;
    private String choice;

    public SpreadChoiceRequest() {
    }

    public SpreadChoiceRequest(int userId, int spreadId, String choice) {
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

    @Override
    public String toString() {
        return "SpreadChoiceRequest{" +
                "userId=" + userId +
                ", spreadId=" + spreadId +
                ", choice='" + choice + '\'' +
                '}';
    }
}
