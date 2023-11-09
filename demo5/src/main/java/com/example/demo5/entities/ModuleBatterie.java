package com.example.demo5.entities;

import java.sql.Timestamp;

public class ModuleBatterie {
    int Id;
    int IdModule;
    String NumeroBatterie;
    int IdBatterie;
    double VoltageBatterie;
    double ValeurBatterie;
    Timestamp Temps;

    public ModuleBatterie(){}

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getIdModule() {
        return IdModule;
    }

    public void setIdModule(int idModule) {
        IdModule = idModule;
    }

    public String getNumeroBatterie() {
        return NumeroBatterie;
    }

    public void setNumeroBatterie(String numeroBatterie) {
        NumeroBatterie = numeroBatterie;
    }

    public int getIdBatterie() {
        return IdBatterie;
    }

    public void setIdBatterie(int idBatterie) {
        IdBatterie = idBatterie;
    }

    public double getVoltageBatterie() {
        return VoltageBatterie;
    }

    public void setVoltageBatterie(double voltageBatterie) {
        VoltageBatterie = voltageBatterie;
    }

    public double getValeurBatterie() {
        return ValeurBatterie;
    }

    public void setValeurBatterie(double valeurBatterie) {
        ValeurBatterie = valeurBatterie;
    }

    public Timestamp getTemps() {
        return Temps;
    }

    public void setTemps(Timestamp temps) {
        Temps = temps;
    }
}