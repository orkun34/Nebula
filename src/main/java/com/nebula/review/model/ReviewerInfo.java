package com.nebula.review.model;

import com.google.common.base.CharMatcher;

public class ReviewerInfo {

    private String name;
    private String email;
    private String productId;

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    private String review;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    @Override
    public String toString() {
        return "ReviewerInfo{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", productId='" + productId + '\'' +
                ", review='" + review + '\'' +
                '}';
    }
}
