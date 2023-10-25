package com.example.demo5.fonc;

import javafx.beans.binding.Bindings;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class Utilites {
    public static Timestamp generateTime() {
        long milliseconds = System.currentTimeMillis();
        return new Timestamp(milliseconds);
    }

    public static Timestamp castToTimestamp(String dateString) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        java.util.Date parsedDate = dateFormat.parse(dateString);
        Timestamp timestamp = new Timestamp(parsedDate.getTime());
        return timestamp;
    }

    public static Timestamp makeTime(String mois, String jour, String heure) throws ParseException {
        String annee = "2023";
        String dateString = annee + "-" + mois + "-" + jour + " " + heure + ":00:00";

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Date parsedDate = dateFormat.parse(dateString);

        return new Timestamp(parsedDate.getTime());
    }

//    public static Timestamp generateTimestamp() {
//        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Indian/Antananarivo"));
//        long currentTimeMillis = cal.getTimeInMillis();
//        return new Timestamp(currentTimeMillis);
//    }

    public static Timestamp generateTimestamp(){
        long milliseconds = System.currentTimeMillis();
        Timestamp temps = new Timestamp(milliseconds);
        return temps;
    }
}
