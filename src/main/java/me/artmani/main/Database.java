package me.artmani.main;

import java.sql.*;

public class Database {

    Connection connection;

    public Database() throws SQLException {

        String url = "jdbc:sqlite:C:\\Users\\kak7\\Documents\\GitHub\\statisticaldata\\studentData.db";
        connection = DriverManager.getConnection(url);
        connection.setAutoCommit(true);

    }

    public void executeQuery(String query) throws SQLException {

        Statement statement = connection.createStatement();
        statement.executeUpdate(query);
    }

    public ResultSet getResultSet(String query) throws SQLException {

        Statement statement = connection.createStatement();
        return statement.executeQuery(query);

    }


}
