package com.nebula.review.model.db;

import javax.persistence.*;
import java.util.Date;

@Entity(name="productreview")
public class ProductReview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productreviewid")
    Long productReviewId;

    @Column(name = "productid")
    Long productId;

    @Column(name = "reviewername")
    String reviewerName;

    @Column(name="reviewdate")
    Date reviewData;

    @Column(name = "emailaddress")
    String emailAddress;

    @Column(name = "rating")
    Long rating;

    @Column(name = "comments")
    String comments;

    @Column(name="modifieddate")
    Date modifiedDate;


    public ProductReview(Long productId,String reviewerName, Date reviewData, String emailAddress, Long rating, String comments, Date modifiedDate) {
        this.productId=productId;
        this.reviewerName = reviewerName;
        this.reviewData = reviewData;
        this.emailAddress = emailAddress;
        this.rating = rating;
        this.comments = comments;
        this.modifiedDate = modifiedDate;
    }

    public Long getProductReviewId() {
        return productReviewId;
    }

    public void setProductReviewId(Long productReviewId) {
        this.productReviewId = productReviewId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getReviewerName() {
        return reviewerName;
    }

    public void setReviewerName(String reviewerName) {
        this.reviewerName = reviewerName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public Long getRating() {
        return rating;
    }

    public void setRating(Long rating) {
        this.rating = rating;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Date getReviewData() {
        return reviewData;
    }

    public void setReviewData(Date reviewData) {
        this.reviewData = reviewData;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

}
