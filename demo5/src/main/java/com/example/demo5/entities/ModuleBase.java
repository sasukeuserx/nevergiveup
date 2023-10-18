package com.example.demo5.entities;

public class ModuleBase {
    int Id;
    String QrCode;
    int IdBatterie;

    public ModuleBase(){}

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getQrCode() {
        return QrCode;
    }

    public void setQrCode(String qrCode) {
        QrCode = qrCode;
    }

    public int getIdBatterie() {
        return IdBatterie;
    }

    public void setIdBatterie(int idBatterie) {
        IdBatterie = idBatterie;
    }
}
