package com.feedbacksystem.database;

import com.feedbacksystem.exception.DatabaseException;
import com.feedbacksystem.model.Feedback;
import com.feedbacksystem.util.DBUtil;
import com.feedbacksystem.util.LoggerUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FeedbackDAO {

    // CREATE
    public boolean addFeedback(Feedback feedback) {
        String query = "INSERT INTO feedback (customer_id, product_id, message, rating, feedback_date) VALUES (?, ?, ?, ?, CURRENT_TIMESTAMP)";
        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setInt(1, feedback.getCustomerId());
            ps.setInt(2, feedback.getProductId());
            ps.setString(3, feedback.getMessage());
            ps.setInt(4, feedback.getRating());

            int rows = ps.executeUpdate();
            return rows > 0;

        } catch (SQLException e) {
            LoggerUtil.logger.error("Error inserting feedback: " + e.getMessage());
            throw new DatabaseException("Error inserting feedback! ", e);
        }
    }

    // READ
    public List<Feedback> getAllFeedback() {
        List<Feedback> feedbackList = new ArrayList<>();
        String query = "SELECT * FROM feedback";
        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Feedback f = new Feedback();
                f.setFeedbackId(rs.getInt("feedback_id"));
                f.setCustomerId(rs.getInt("customer_id"));
                f.setProductId(rs.getInt("product_id"));
                f.setMessage(rs.getString("message"));
                f.setRating(rs.getInt("rating"));
                f.setFeedbackDate(rs.getTimestamp("feedback_date"));
                feedbackList.add(f);
            }

        } catch (SQLException e) {
            LoggerUtil.logger.error("Error fetching feedback: " + e.getMessage());
            throw new DatabaseException("Error fetching feedback! ", e);
        }
        return feedbackList;
    }

    // UPDATE
    public boolean updateFeedback(Feedback feedback) {
        String query = "UPDATE feedback SET message = ?, rating = ?, product_id = ? WHERE feedback_id = ?";
        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setString(1, feedback.getMessage());
            ps.setInt(2, feedback.getRating());
            ps.setInt(3, feedback.getProductId());
            ps.setInt(4, feedback.getFeedbackId());

            int rows = ps.executeUpdate();
            return rows > 0;

        } catch (SQLException e) {
            LoggerUtil.logger.error("Error updating feedback: " + e.getMessage());
            throw new DatabaseException("Error updating feedback! ", e);
        }
    }

    // DELETE
    public boolean deleteFeedback(int feedbackId) {
        String query = "DELETE FROM feedback WHERE feedback_id = ?";
        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setInt(1, feedbackId);
            int rows = ps.executeUpdate();
            return rows > 0;

        } catch (SQLException e) {
            LoggerUtil.logger.error("Error deleting feedback: " + e.getMessage());
            throw new DatabaseException("Error deleting feedback! ", e);
        }
    }
}
