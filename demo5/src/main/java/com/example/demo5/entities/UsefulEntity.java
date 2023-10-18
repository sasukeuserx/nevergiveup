package com.example.demo5.entities;

public class UsefulEntity {
    int IdClient;
    boolean State;

    public UsefulEntity(){}

    public UsefulEntity(int idClient, boolean state) {
        IdClient = idClient;
        State = state;
    }

    public int getIdClient() {
        return IdClient;
    }

    public void setIdClient(int idClient) {
        IdClient = idClient;
    }

    public boolean isState() {
        return State;
    }

    public void setState(boolean state) {
        State = state;
    }
}
