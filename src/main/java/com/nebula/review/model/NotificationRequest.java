package com.nebula.review.model;

public class NotificationRequest {

    private String name;
    private boolean isValid;
    private String email;
    private String productId;

    public String getName() {
        return name;
    }

    public boolean isValid() {
        return isValid;
    }

    public String getEmail() {
        return email;
    }

    public String getProductId() {
        return productId;
    }

    private NotificationRequest(NotificationRequestBuilder builder) {
        this.name = builder.name;
        this.isValid = builder.isValid;
        this.email = builder.email;
        this.productId = builder.productId;
    }

    public static class NotificationRequestBuilder{

        private String name;
        private boolean isValid;
        private String email;
        private String productId;

        public NotificationRequestBuilder(String name, boolean isValid, String email) {
            this.name = name;
            this.isValid = isValid;
            this.email = email;
        }

        public NotificationRequestBuilder setProductId(String productId){
            this.productId=productId;
            return this;
        }

        public NotificationRequest builder(){
            return new NotificationRequest(this);
        }
    }
}
