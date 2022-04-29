package me.artmani.main;

import java.sql.*;

public class Database {

    Connection connection;

    public Database() throws SQLException {

        String url = "jdbc:sqlite:C:\\Users\\kaks\\Documents\\GitHub\\statisticaldata\\studentData.sqlite";
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

