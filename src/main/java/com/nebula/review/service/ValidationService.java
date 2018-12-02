package com.nebula.review.service;

import com.nebula.review.common.NebulaProp;
import com.nebula.review.common.SingletonHolder;
import com.nebula.review.model.NotificationRequest;
import com.nebula.review.model.RequestMessage;
import com.nebula.review.service.intrface.IValidation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidationService implements IValidation {

    private static final Logger log = LoggerFactory.getLogger(ValidationService.class);

    @Autowired
    NebulaProp prop;

    @Override
    public boolean isAppropriate(RequestMessage message, String reviewId) {

        log.info("<ValidationService> reached with review :{}",message.getReview());

       /* boolean isValid = !prop.getNonValidList().stream().allMatch(s -> s.equals(message.getReview()));*/

        String[] reviewItems = message.getReview().split(" ");
        Boolean isValid = true;
        for (String propItem : prop.getNonValidList()) {
            for (String reviewItem : reviewItems)
                if(reviewItem.equals(propItem)){
                    isValid = false;
                    break;
                }
        }


        NotificationRequest notificationRequest = new NotificationRequest.NotificationRequestBuilder(message.getName(), String.valueOf(isValid), message.getEmail()).setProductId(message.getProductId()).setReview(message.getReview()).builder();
        SingletonHolder.getInstance().getRequestMessageHashSet().add(notificationRequest);
        if (!isValid) {
            SingletonHolder.getInstance().getReviewedMessageHashMap().put(reviewId, notificationRequest);
        }
        log.info("<ValidationService> flagged with :{}",String.valueOf(isValid));
        return isValid;
    }
}
