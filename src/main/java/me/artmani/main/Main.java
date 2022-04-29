package me.artmani.main;

import lombok.Getter;
import me.artmani.main.ui.MainFrame;

import java.sql.SQLException;

public class Main {

    @Getter
    static Database database;
    public static void main(String[] args) {
        new MainFrame().setVisible(true);
        try {
            database = new Database();
        } catch (SQLException e) {e.printStackTrace();}
    }
}
