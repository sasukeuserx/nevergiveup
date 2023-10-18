package com.example.demo5.entities;

import java.sql.Timestamp;

public class Donnee {
    int Id;
    int IdModule;
    double VoltagePanneau;
    double VoltageOutput;
    double VoltageBatterie;
    double Production;
    double Consommation;
    double ValeurBatterie;

    Timestamp Temps;

    public Donnee(){}

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

    public double getVoltagePanneau() {
        return VoltagePanneau;
    }

    public void setVoltagePanneau(double voltagePanneau) {
        VoltagePanneau = voltagePanneau;
    }

    public double getVoltageOutput() {
        return VoltageOutput;
    }

    public void setVoltageOutput(double voltageOutput) {
        VoltageOutput = voltageOutput;
    }

    public double getVoltageBatterie() {
        return VoltageBatterie;
    }

    public void setVoltageBatterie(double voltageBatterie) {
        VoltageBatterie = voltageBatterie;
    }

    public double getProduction() {
        return Production;
    }

    public void setProduction(double production) {
        Production = production;
    }

    public double getConsommation() {
        return Consommation;
    }

    public void setConsommation(double consommation) {
        Consommation = consommation;
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
