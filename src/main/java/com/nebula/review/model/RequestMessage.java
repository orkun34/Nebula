package com.nebula.review.model;

import java.io.Serializable;

public final class RequestMessage implements Serializable {

    private String name;
    private String email;
    private String productId;
    private String review;

    private String reviewId;
    private boolean isValid;

    public RequestMessage(String name, String email, String productId, String review,String reviewId) {
        this.name = name;
        this.email = email;
        this.productId = productId;
        this.review = review;
        this.reviewId=reviewId;
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getProductId() {
        return productId;
    }

    public String getReview() {
        return review;
    }

    public String getReviewId() {
        return reviewId;
    }

    public void setReviewId(String reviewId) {
        this.reviewId = reviewId;
    }

    @Override
    public String toString() {
        return "RequestMessage{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", productId='" + productId + '\'' +
                ", review='" + review + '\'' +
                ", reviewId='" + reviewId + '\'' +
                ", isValid=" + isValid +
                '}';
    }
}
