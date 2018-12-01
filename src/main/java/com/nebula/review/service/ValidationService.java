package com.nebula.review.service;

import com.google.common.base.CharMatcher;
import com.nebula.review.common.NebulaProp;
import com.nebula.review.common.SingletonHolder;
import com.nebula.review.model.NotificationRequest;
import com.nebula.review.model.RequestMessage;
import com.nebula.review.queue.consumer.RequestConsumer;
import com.nebula.review.service.intrface.IValidation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class ValidationService implements IValidation {

    private static final Logger log = LoggerFactory.getLogger(ValidationService.class);

    @Autowired
    NebulaProp prop;

    @Override
    public boolean isAppropriate(RequestMessage message, String reviewId) {

        log.info("<ValidationService> reached with review :{}",message.getReview());
        boolean isValid =  !prop.getNonValidList().stream().parallel().anyMatch(message.getReview()::contains);

        NotificationRequest notificationRequest = new NotificationRequest.NotificationRequestBuilder(message.getName(), isValid, message.getEmail()).builder();
        if (!isValid) {
            SingletonHolder.getInstance().getReviewedMessageHashMap().put(reviewId, notificationRequest);
        }
        log.info("<ValidationService> flagged with :{}",String.valueOf(isValid));
        return isValid;
    }
}
