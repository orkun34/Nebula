package com.nebula.review.service;

import com.google.common.base.CharMatcher;
import com.nebula.review.common.SingletonHolder;
import com.nebula.review.model.NotificationRequest;
import com.nebula.review.model.RequestMessage;
import com.nebula.review.service.intrface.IValidation;
import org.springframework.stereotype.Component;

@Component
public class ValidationService implements IValidation {

    @Override
    public boolean isAppropriate(RequestMessage message, String reviewId) {

        boolean isValid = CharMatcher.ascii().matchesAllOf(message.getReview().subSequence(1,message.getReview().length()));

        NotificationRequest notificationRequest = new NotificationRequest.NotificationRequestBuilder(message.getName(), isValid, message.getEmail()).builder();
        if (!isValid) {
            SingletonHolder.getInstance().getReviewedMessageHashMap().put(reviewId, notificationRequest);
        }

        return isValid;
    }
}
