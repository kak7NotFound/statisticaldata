package me.artmani.main;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Database {

    Connection connection;

    public Database() throws SQLException {

        File f = new File(Main.class.getProtectionDomain().getCodeSource().getLocation().getFile()).getParentFile();
        var url = "jdbc:sqlite:" + f + "\\studentData.sqlite";
        // раскомmентить если в intellij idea
//        url = "jdbc:sqlite:C:\\Users\\kaks\\Documents\\GitHub\\statisticaldata\\studentData.sqlite";
        System.out.println(url);

        connection = DriverManager.getConnection(url);
        connection.setAutoCommit(true);
    }

    public void executeQuery(String query) throws SQLException {
        connection.createStatement().executeUpdate(query);
    }

    public ResultSet getResultSet(String query) throws SQLException {
        return connection.createStatement().executeQuery(query);
    }

}

