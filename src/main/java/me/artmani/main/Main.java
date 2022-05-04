package me.artmani.main;

import lombok.Getter;
import me.artmani.main.ui.MainFrame;

import java.sql.SQLException;

public class Main {

    @Getter
    static Database database;

    @Getter
    static String firstSemesterDate = "01.09";
    @Getter
    static String secondSemesterDate = "01.02";
    public static void main(String[] args) {
        try {
            database = new Database();
        } catch (SQLException e) {e.printStackTrace();}
        new MainFrame().setVisible(true);

    }
}
