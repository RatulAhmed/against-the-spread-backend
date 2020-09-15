package com.atspickem.backend.models;

public class AuthenticationResponse {

    private final String jwt;
    private int id;
    private String username;

    public AuthenticationResponse(String jwt) {
        this.jwt = jwt;
    }

    public AuthenticationResponse(String jwt, int id, String username) {
        this.jwt = jwt;
        this.id = id;
        this.username = username;
    }

    public String getJwt() {
        return jwt;
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
}
