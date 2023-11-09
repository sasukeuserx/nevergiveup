package com.example.demo5.entities;

public class ModuleBase {
    int Id;
    String QrCode;
    String NomModule;
    int IdBatterie;
    String SsidESP;
    String PasswordESP;
    String Ssid;
    String Password;
    boolean State;
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

    public String getSsidESP() {
        return SsidESP;
    }

    public void setSsidESP(String ssidESP) {
        SsidESP = ssidESP;
    }

    public String getPasswordESP() {
        return PasswordESP;
    }

    public void setPasswordESP(String passwordESP) {
        PasswordESP = passwordESP;
    }

    public String getSsid() {
        return Ssid;
    }

    public void setSsid(String ssid) {
        Ssid = ssid;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public boolean isState() {
        return State;
    }

    public void setState(boolean state) {
        State = state;
    }
}
