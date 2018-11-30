package com.nebula.review.service.intrface;

import com.nebula.review.model.RequestMessage;

public interface IValidation {

    boolean isAppropriate(RequestMessage review, String reviewId);
}
