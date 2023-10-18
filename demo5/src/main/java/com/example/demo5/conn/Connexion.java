package com.example.demo5.conn;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connexion {
    public static Connection getConn() throws Exception{
        String url="jdbc:postgresql://containers-us-west-100.railway.app:7636/railway";
        String user="postgres";
        String pass="7yJS4KFH6oCkr3gOSnmK";
        Class.forName("org.postgresql.Driver");
        Connection conn = DriverManager.getConnection(url,user,pass);
        return conn;
    }
}
