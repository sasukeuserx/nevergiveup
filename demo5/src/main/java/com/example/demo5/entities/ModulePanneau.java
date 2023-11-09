package com.example.demo5.entities;

import java.sql.Timestamp;

public class ModulePanneau {
    int Id;
    int IdModule;
    String NumeroPanneau;
    double Production;
    Timestamp Temps;

    public ModulePanneau(){}

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

    public String getNumeroPanneau() {
        return NumeroPanneau;
    }

    public void setNumeroPanneau(String numeroPanneau) {
        NumeroPanneau = numeroPanneau;
    }

    public double getProduction() {
        return Production;
    }

    public void setProduction(double production) {
        Production = production;
    }

    public Timestamp getTemps() {
        return Temps;
    }

    public void setTemps(Timestamp temps) {
        Temps = temps;
    }
}
