package com.example.demo5.entities;

public class VClientModule {
    int IdModule;
    String QrCode;
    String NomModule;
    int IdBatterie;
    int IdClient;

    public VClientModule(){}

    public int getIdModule() {
        return IdModule;
    }

    public void setIdModule(int idModule) {
        IdModule = idModule;
    }

    public String getQrCode() {
        return QrCode;
    }

    public void setQrCode(String qrCode) {
        QrCode = qrCode;
    }

    public String getNomModule() {
        return NomModule;
    }

    public void setNomModule(String nomModule) {
        NomModule = nomModule;
    }

    public int getIdBatterie() {
        return IdBatterie;
    }

    public void setIdBatterie(int idBatterie) {
        IdBatterie = idBatterie;
    }

    public int getIdClient() {
        return IdClient;
    }

    public void setIdClient(int idClient) {
        IdClient = idClient;
    }
}
