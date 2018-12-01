package com.nebula.review.model;

public class ResponseMessage {

    private String success;
    private String reviewID;

    public ResponseMessage(String success, String reviewID) {
        this.success = success;
        this.reviewID = reviewID;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getReviewID() {
        return reviewID;
    }

    public void setReviewID(String reviewID) {
        this.reviewID = reviewID;
    }

    @Override
    public String toString() {
        return "ResponseMessage{" +
                "success='" + success + '\'' +
                ", reviewID='" + reviewID + '\'' +
                '}';
    }
}
