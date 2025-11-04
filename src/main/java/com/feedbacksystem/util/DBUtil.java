package com.feedbacksystem.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static java.lang.Class.forName;

public class DBUtil {

    private static final String URL="jdbc:mysql://localhost:3306/customer_feedback_db";
    private static final String USERNAME="root";
    private static final String PASSWORD="Prem@1102";

    public static Connection getConnection(){
        Connection connection=null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            LoggerUtil.logger.info("Database Connected Successfully!");

        } catch (ClassNotFoundException e) {
            LoggerUtil.logger.error("MySQL Driver not Found:"+e.getMessage());

        } catch (SQLException e) {
            LoggerUtil.logger.error("Database Connection Failed:"+e.getMessage());
        }

        return connection;
    }
    public static void main(String[] args) {
        DBUtil.getConnection();
    }

}

