package com.feedbacksystem.util;

import java.sql.Connection;

public class DBConnectionTest {
    public static void main(String[] args) {
        Connection conn = DBUtil.getConnection();
        if (conn != null) {
            LoggerUtil.logger.info("Connection test passed!");
        } else {
            LoggerUtil.logger.warn("Connection test failed:");
        }
    }
}
