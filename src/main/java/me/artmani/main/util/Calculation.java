package me.artmani.main.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Calculation {

    public float countAvg(){
        return 1.1f;
    }

    static public int convertDateToUnixTimestamp(String date){
        // 01.01.2020

        int day;
        int month;
        int year;

        var splitDate = date.split("\\.");
        year = Integer.parseInt(splitDate[splitDate.length-1]);
        month = Integer.parseInt(splitDate[splitDate.length-2]);

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
            Date dt = sdf.parse(date);
            long epoch = dt.getTime();
            return (int)(epoch/1000);
        } catch(Exception e) {
            e.printStackTrace();
        }

        return 0;
    }

    static public ArrayList<String> getMonthRange(String startDate, String endDate){
        var dates = new ArrayList<String>();
        var splitStartDate = startDate.split("\\.");
        var splitEndDate = endDate.split("\\.");



        return dates;
    }

}
