package com.example.demo5.fonc;

import com.example.demo5.conn.Connexion;
import com.example.demo5.entities.ModuleBase;
import com.example.demo5.entities.ModuleBatterie;
import com.example.demo5.entities.ModulePanneau;

import java.sql.*;
import java.util.ArrayList;

import static com.example.demo5.fonc.Fonction.getModuleById;
import static com.example.demo5.fonc.Fonction.getTypeBatterieById;

public class FonctionModule {
    static Connexion conn = new Connexion();
    public static void insertDonneeBatterie(int idmodule, String numerobatterie, int idbatterie, String voltagebatterie) throws Exception {
        ModuleBase module = getModuleById(idmodule);
        double capacitebatterie = getTypeBatterieById(module.getIdBatterie()).getValeur();
        double pourcentage = 0;
        pourcentage = (Double.parseDouble(voltagebatterie) * 100)/capacitebatterie;
        String sql = "insert into modulebatterie(idmodule,numerobatterie,idbatterie,voltagebatterie,valeurbatterie,temps) values ";
        sql += "("+idmodule+",'"+numerobatterie+"',"+idbatterie+","+Double.parseDouble(voltagebatterie)+","+pourcentage+",'"+Utilites.generateTime()+"')";
        Connection connection = conn.getConn();
        Statement stmt = connection.createStatement();
        stmt.executeUpdate(sql);
        connection.close();
    }

    public static void insertDonneePanneau(int idmodule, String numeropanneau, Double production)throws Exception{
        String sql = "insert into modulepanneau(idmodule,numeropanneau,production,temps) values ";
        sql += "("+idmodule+",'"+numeropanneau+"',"+production+",'"+Utilites.generateTime()+"')";
        Connection connection = conn.getConn();
        Statement stmt = connection.createStatement();
        stmt.executeUpdate(sql);
        connection.close();
    }

    public static ArrayList<ModuleBatterie> getListBatterieByIdModuleNumeroBatterie(int idmodule, String numeroBatterie) throws Exception{
        String sql = "select * from modulebatterie where idmodule="+idmodule+" and numerobatterie="+numeroBatterie;
        Connection connection = conn.getConn();
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        ArrayList<ModuleBatterie> res = new ArrayList<>();
        while(rs.next()){
            ModuleBatterie mb = new ModuleBatterie();
            mb.setIdModule(rs.getInt("idmodule"));
            mb.setNumeroBatterie(rs.getString("numerobatterie"));
            mb.setIdBatterie(rs.getInt("idbatterie"));
            mb.setVoltageBatterie(rs.getDouble("voltagebatterie"));
            mb.setValeurBatterie(rs.getDouble("valeurbatterie"));
            mb.setTemps(rs.getTimestamp("temps"));
            res.add(mb);
        }
        connection.close();
        return res;
    }

    public static ArrayList<ModulePanneau> getListPanneauByIdModuleNumeroPanneau(int idmodule, String numeroPanneau) throws Exception{
        String sql = "select * from modulepanneau where idmodule="+idmodule+" and numeropanneau="+numeroPanneau;
        Connection connection = conn.getConn();
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        ArrayList<ModulePanneau> res = new ArrayList<>();
        while(rs.next()){
            ModulePanneau mb = new ModulePanneau();
            mb.setIdModule(rs.getInt("idmodule"));
            mb.setNumeroPanneau(rs.getString("numeropanneau"));
            mb.setProduction(rs.getInt("production"));
            mb.setTemps(rs.getTimestamp("temps"));
            res.add(mb);
        }
        connection.close();
        return res;
    }

}