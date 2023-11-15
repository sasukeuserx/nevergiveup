package com.example.demo5.entities;

import java.sql.Timestamp;

public class TableConsommation {
    int Id;
    int IdModule;
    double Valeur;
    Timestamp Temps;

    public TableConsommation(){}
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

    public double getValeur() {
        return Valeur;
    }

    public void setValeur(double valeur) {
        Valeur = valeur;
    }

    public Timestamp getTemps() {
        return Temps;
    }

    public void setTemps(Timestamp temps) {
        Temps = temps;
    }
}
