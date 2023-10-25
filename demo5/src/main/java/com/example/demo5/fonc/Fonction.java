package com.example.demo5.fonc;

import com.example.demo5.conn.Connexion;
import com.example.demo5.entities.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.Objects;

public class Fonction {
    static Connexion connexion = new Connexion();

    public static Connexion conn = new Connexion();
    public static TypeBatterie getTypeBatterieById(int idtypebatterie) throws Exception{
        String sql = "select * from typebatterie where id="+idtypebatterie;
        Connection connection = conn.getConn();
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        TypeBatterie res = new TypeBatterie();
        while(rs.next()){
            res.setId(rs.getInt("id"));
            res.setValeur(rs.getInt("valeur"));
        }
        connection.close();
        return res;
    }

    public static ArrayList<TypeBatterie> getListeTypeBatterie() throws Exception{
        String sql = "select * from typebatterie";
        Connection connection = conn.getConn();
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        ArrayList<TypeBatterie> liste = new ArrayList<>();
        while(rs.next()){
            TypeBatterie res = new TypeBatterie();
            res.setId(rs.getInt("id"));
            res.setValeur(rs.getInt("valeur"));
            liste.add(res);
        }
        connection.close();
        return liste;
    }

    public static ArrayList<Client> getListClient() throws Exception{
        String sql = "select * from client";
        Connection connection = conn.getConn();
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        ArrayList<Client> clients = new ArrayList<>();
        while(rs.next()){
            Client cl = new Client();
            cl.setId(rs.getInt("id"));
            cl.setNom(rs.getString("nom"));
            cl.setPrenom(rs.getString("prenom"));
            cl.setEmail(rs.getString("email"));
            cl.setPass(rs.getString("pass"));
            cl.setLienImage(rs.getString("lienimage"));
            cl.setCodePostal(rs.getString("codepostal"));
            cl.setAdresse(rs.getString("adresse"));
            clients.add(cl);
        }
        connection.close();
        return clients;
    }

    public static Client getClientById(int id) throws Exception{
        String sql = "select * from client where id="+id;
        Connection connection = conn.getConn();
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        Client cl = new Client();
        while(rs.next()){
            cl.setId(rs.getInt("id"));
            cl.setNom(rs.getString("nom"));
            cl.setPrenom(rs.getString("prenom"));
            cl.setEmail(rs.getString("email"));
            cl.setPass(rs.getString("pass"));
            cl.setLienImage(rs.getString("lienimage"));
            cl.setCodePostal(rs.getString("codepostal"));
            cl.setAdresse(rs.getString("adresse"));
        }
        connection.close();
        return cl;
    }

    public static UsefulEntity loginClient(String email, String pass) throws Exception{
        UsefulEntity usefulEntitySolar = new UsefulEntity();
        usefulEntitySolar.setState(false);
        ArrayList<Client> liste = getListClient();
        for(int i=0; i<liste.size(); i++){
            if((Objects.equals(email, liste.get(i).getEmail()) && Objects.equals(pass, liste.get(i).getPass()))){
                usefulEntitySolar.setIdClient(liste.get(i).getId());
                usefulEntitySolar.setState(true);
            }
        }
        return usefulEntitySolar;
    }

    public static void signUpClient(String nom, String prenom, String email, String pass, String lienimage, String adresse, String codepostale) throws Exception{
        String sql = "insert into client(nom,prenom,email,pass,lienimage,adresse,codepostal) values ('"+nom+"','"+prenom+"','"+email+"','"+pass+"','"+lienimage+"','"+adresse+"','"+codepostale+"')";
        Connection connection = conn.getConn();
        Statement stmt = connection.createStatement();
        stmt.executeUpdate(sql);
        connection.close();
    }

    public static void insertDonnee(String idmodule, String voltagepanneau, String voltageoutput, String voltagebatterie, String consommation, String production) throws Exception {
        long milliseconds = System.currentTimeMillis();
        Timestamp temps = new Timestamp(milliseconds);
        ModuleBase module = getModuleById(Integer.parseInt(idmodule));
        double capacitebatterie = getTypeBatterieById(module.getIdBatterie()).getValeur();
        double pourcentage = 0;
        double[] val = new double[5];
        val[0] = Double.parseDouble(voltagepanneau);
        val[1] = Double.parseDouble(voltageoutput);
        val[2] = Double.parseDouble(voltagebatterie);
        val[3] = Double.parseDouble(production);
        val[4] = Double.parseDouble(consommation);
        pourcentage = (Double.parseDouble(voltagebatterie) * 100)/capacitebatterie;
        String sql = "insert into donnees(idmodule,voltagepanneau,voltageoutput,voltagebatterie,production,consommation,valeurbatterie,temps) values ("+Integer.parseInt(idmodule)+","+val[0]+","+val[1]+","+val[2]+","+val[3]+","+val[4]+","+pourcentage+",'"+temps+"')";
        Connection connection = conn.getConn();
        Statement stmt = connection.createStatement();
        stmt.executeUpdate(sql);
        connection.close();
    }

    public static ArrayList<Donnee> getListDonnee() throws Exception {
        String sql = "select * from donnees";
        Connection connection = conn.getConn();
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        ArrayList<Donnee> liste = new ArrayList<>();
        while(rs.next()){
            Donnee d = new Donnee();
            d.setId(rs.getInt("id"));
            d.setIdModule(rs.getInt("idmodule"));
            d.setVoltagePanneau(rs.getDouble("voltagepanneau"));
            d.setVoltageOutput(rs.getDouble("voltageoutput"));
            d.setVoltageBatterie(rs.getDouble("voltagebatterie"));
            d.setProduction(rs.getDouble("production"));
            d.setConsommation(rs.getDouble("consommation"));
            d.setTemps(rs.getTimestamp("temps"));
            d.setValeurBatterie(rs.getDouble("valeurbatterie"));
            liste.add(d);
        }
        connection.close();
        return liste;
    }

    public static ArrayList<Donnee> getListDonneeSpecifique(String mois, String jour, String heure1, String heure2) throws Exception {
        Timestamp t1 = Utilites.makeTime(mois,jour,heure1);
        Timestamp t2 = Utilites.makeTime(mois,jour,heure2);
        String sql = "select * from donnees where temps >= '"+t1+"' and temps <= '"+t2+"'";
        Connection connection = conn.getConn();
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        ArrayList<Donnee> liste = new ArrayList<>();
        while(rs.next()){
            Donnee d = new Donnee();
            d.setIdModule(rs.getInt("idmodule"));
            d.setVoltagePanneau(rs.getDouble("voltagepanneau"));
            d.setVoltageOutput(rs.getDouble("voltageoutput"));
            d.setVoltageBatterie(rs.getDouble("voltagebatterie"));
            d.setProduction(rs.getDouble("production"));
            d.setConsommation(rs.getDouble("consommation"));
            d.setTemps(rs.getTimestamp("temps"));
            d.setValeurBatterie(rs.getDouble("valeurbatterie"));
            liste.add(d);
        }
        connection.close();
        return liste;
    }
    public static void insertModule(String qrcode, String idbatterie){
        String sql = "insert into module(qrcode,idbatterie) values ('"+qrcode+"',"+Integer.parseInt(idbatterie)+")";
        try{
            Connection connection = conn.getConn();
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(sql);
            connection.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public static ModuleBase getModuleById(int id) throws Exception{
        String sql = "select * from module where id="+id;
        Connection connection = conn.getConn();
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        ModuleBase res = new ModuleBase();
        while(rs.next()){
            res.setId(rs.getInt("id"));
            res.setQrCode(rs.getString("qrcode"));
            res.setIdBatterie(rs.getInt("idbatterie"));
        }
        connection.close();
        return res;
    }

    public static ArrayList<ModuleBase> getListModule() throws Exception{
        String sql = "select * from module";
        Connection connection = conn.getConn();
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        ArrayList<ModuleBase> liste = new ArrayList<>();
        while(rs.next()){
            ModuleBase res = new ModuleBase();
            res.setId(rs.getInt("id"));
            res.setQrCode(rs.getString("qrcode"));
            res.setIdBatterie(rs.getInt("idbatterie"));
            liste.add(res);
        }
        connection.close();
        return liste;
    }

    public static ClientModule getClientModuleByIdClient(int idclient)throws Exception{
        String sql = "select * from clientmodule module where idclient="+idclient;
        Connection connection = conn.getConn();
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        ClientModule res = new ClientModule();
        while (rs.next()){
            res.setIdModule(rs.getInt("idmodule"));
            res.setIdClient(rs.getInt("idclient"));
        }
        connection.close();
        return res;
    }

    public static ModuleBase moduleByIdClient(int idclient) throws Exception{
        return getModuleById(getClientModuleByIdClient(idclient).getIdModule());
    }

    public static void AttributionModuleClient(String idmodule, String idclient){
        String sql = "insert into clientmodule(idclient,idmodule) values ("+idclient+","+idmodule+")";
        try{
            Connection connection = conn.getConn();
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(sql);
            connection.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void DeleteData(){
        String sql = "delete from donnees";
        try{
            Connection connection = conn.getConn();
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(sql);
            connection.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

    }
}
