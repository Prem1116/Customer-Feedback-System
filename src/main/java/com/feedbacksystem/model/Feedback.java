package com.feedbacksystem.model;

import java.sql.Timestamp;

public class Feedback {
    private int feedbackId;
    private int customerId;
    private int productId;
    private String message;
    private int rating;
    private Timestamp feedbackDate;

    //Constructor
    public Feedback(){}

    public Feedback(int feedbackId, int customerId,int productId, String message, int rating, Timestamp feedbackDate) {
        this.feedbackId = feedbackId;
        this.customerId = customerId;
        this.productId = productId;
        this.message = message;
        this.rating = rating;
        this.feedbackDate = feedbackDate;
    }

    //Getter & Setter
    public int getFeedbackId() {return feedbackId;}
    public void setFeedbackId(int feedbackId) {this.feedbackId = feedbackId;}

    public int getCustomerId() {return customerId;}
    public void setCustomerId(int customerId) {this.customerId = customerId;}

    public int getProductId() {return productId;}
    public void setProductId(int productId) {this.productId = productId;}

    public String getMessage() {return message;}
    public void setMessage(String message) {this.message = message;}

    public int getRating() {return rating;}
    public void setRating(int rating) {this.rating = rating;}

    public Timestamp getFeedbackDate() {return feedbackDate;}
    public void setFeedbackDate(Timestamp feedbackDate) {this.feedbackDate = feedbackDate;}


    @Override
    public String toString() {
        return "Feedback{" +
                "FeedbackId=" + feedbackId +
                ", CustomerId=" + customerId +
                ", Message='" + message + '\'' +
                ", Ratings=" + rating +
                ", FeedbackDate=" + feedbackDate +
                '}';
    }

}
