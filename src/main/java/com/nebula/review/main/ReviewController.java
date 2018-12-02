package com.nebula.review.main;

import com.nebula.review.common.NebulaConstant;
import com.nebula.review.common.SingletonHolder;
import com.nebula.review.model.RequestMessage;
import com.nebula.review.model.ResponseMessage;
import com.nebula.review.model.ReviewerInfo;
import com.nebula.review.repo.intrface.IAdventureWorks;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class ReviewController {

    @Autowired
    IAdventureWorks adventureWorks;


    private static final Logger log = LoggerFactory.getLogger(ReviewController.class);

    private final RabbitTemplate rabbitTemplate;

    public ReviewController(final RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @PostMapping(path = "/api/reviews", consumes = { "application/json" })
    @ResponseBody
    public ResponseMessage nebulaProductReview(@RequestBody String body) throws IOException {

        log.info("Rest request just received !!!");

        ReviewerInfo reviewerInfo = SingletonHolder.getInstance().getGson().fromJson(body,ReviewerInfo.class);

        String reviewID =  SingletonHolder.getInstance().generateReviewID();

        final RequestMessage requestMessage = new RequestMessage(reviewerInfo.getName(),reviewerInfo.getEmail(),reviewerInfo.getProductId(),reviewerInfo.getReview(),reviewID);
        rabbitTemplate.convertAndSend(NebulaConstant.REQUEST_EXCHANGE_NAME,NebulaConstant.REQUEST_ROUTING_KEY,requestMessage);

        ResponseMessage response = new ResponseMessage(Boolean.TRUE.toString(),reviewID);

        return response;
    }
}
