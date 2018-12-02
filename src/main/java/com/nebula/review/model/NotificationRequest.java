package com.nebula.review.model;

public class NotificationRequest {

    private String name;
    private String isValid;
    private String email;
    private String productId;
    private String review;

    public String getName() {
        return name;
    }

    public String getIsValid() {
        return isValid;
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



    private NotificationRequest(NotificationRequestBuilder builder) {
        this.name = builder.name;
        this.isValid = builder.isValid;
        this.email = builder.email;
        this.productId = builder.productId;
    }

    public static class NotificationRequestBuilder{

        private String name;
        private String isValid;
        private String email;
        private String productId;
        private String review;

        public NotificationRequestBuilder(String name, String isValid, String email) {
            this.name = name;
            this.isValid = isValid;
            this.email = email;
        }

        public NotificationRequestBuilder setProductId(String productId){
            this.productId=productId;
            return this;
        }

        public NotificationRequestBuilder setReview(String review){
            this.review=review;
            return this;
        }


        public NotificationRequest builder(){
            return new NotificationRequest(this);
        }
    }

    @Override
    public String toString() {
        return "NotificationRequest{" +
                "name='" + name + '\'' +
                ", isValid=" + isValid +
                ", email='" + email + '\'' +
                ", productId='" + productId + '\'' +
                '}';
    }
}
