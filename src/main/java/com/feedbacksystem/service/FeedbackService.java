package com.feedbacksystem.service;

import com.feedbacksystem.database.FeedbackDAO;
import com.feedbacksystem.exception.DatabaseException;
import com.feedbacksystem.model.Feedback;
import com.feedbacksystem.util.LoggerUtil;

import java.util.List;

public class FeedbackService {

    private final FeedbackDAO feedbackDAO = new FeedbackDAO();

    public boolean addFeedback(Feedback feedback) {
        try {
            boolean added = feedbackDAO.addFeedback(feedback);
            if (added) {
                LoggerUtil.logger.info("Feedback added successfully!");
            }
            return added;
        } catch (DatabaseException e) {
            LoggerUtil.logger.error("Failed to add feedback!", e);
            return false;
        }
    }

    public List<Feedback> getAllFeedback() {
        try {
            return feedbackDAO.getAllFeedback();
        } catch (Exception e) {
            LoggerUtil.logger.error("Error fetching feedback!", e);
            return List.of();
        }
    }

    public boolean updateFeedback(Feedback feedback) {
        try {
            boolean updated = feedbackDAO.updateFeedback(feedback);
            if (updated) {
                LoggerUtil.logger.info("Feedback updated successfully!");
            }
            return updated;
        } catch (DatabaseException e) {
            LoggerUtil.logger.error("Failed to update feedback!", e);
            return false;
        }
    }

    public boolean deleteFeedback(int feedbackId) {
        try {
            boolean deleted = feedbackDAO.deleteFeedback(feedbackId);
            if (deleted) {
                LoggerUtil.logger.info("Feedback deleted successfully!");
            }
            return deleted;
        } catch (DatabaseException e) {
            LoggerUtil.logger.error("Failed to delete feedback!", e);
            return false;
        }
    }
}

