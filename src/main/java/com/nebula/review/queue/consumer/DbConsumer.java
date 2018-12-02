package com.nebula.review.queue.consumer;

import com.nebula.review.common.NebulaConstant;
import com.nebula.review.common.SingletonHolder;
import com.nebula.review.model.NotificationRequest;
import com.nebula.review.model.RequestMessage;
import com.nebula.review.repo.intrface.IAdventureWorks;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DbConsumer {

    @Autowired
    IAdventureWorks adventureWorks;

    private static final Logger log = LoggerFactory.getLogger(RequestConsumer.class);

    private final RabbitTemplate rabbitTemplate;

    public DbConsumer(final RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @RabbitListener(queues = NebulaConstant.DB_QUEUE_NAME)
    public void receiveDbMessage(final RequestMessage message) {
        log.info("Received {} : {}", NebulaConstant.DB_QUEUE_NAME, message.toString());
        adventureWorks.insertReview(message);
        NotificationRequest request = new NotificationRequest.NotificationRequestBuilder(message.getName(),String.valueOf(Boolean.TRUE),message.getEmail()).builder();
        SingletonHolder.getInstance().getReviewedMessageHashMap().put(message.getReviewId(), request);
    }
}
