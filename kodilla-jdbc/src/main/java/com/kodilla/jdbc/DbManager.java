package com.kodilla.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbManager {

    private  static DbManager dbManagerInstance;

    private Connection conn;

    DbManager() {
        Properties connectionProps = new Properties();
        connectionProps.put("user", "kodilla_user2");
        connectionProps.put("password", "kodilla_Pass123");
        try {
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/kodilla_course" +
                            "?serverTimezone=Europe/Warsaw" +
                            "&useSSL=False",
                    connectionProps);
        } catch (SQLException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public static DbManager getInstance() {
        if(dbManagerInstance == null){
            dbManagerInstance = new DbManager();
        }
        return dbManagerInstance;
    }

    public Connection getConnection() {
        return conn;
    }
}

