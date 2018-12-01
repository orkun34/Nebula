package com.nebula.review.queue.producer;

import com.nebula.review.common.NebulaConstant;
import com.nebula.review.model.RequestMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;


@Service
public class RequestProducer {

    private static final Logger log = LoggerFactory.getLogger(RequestProducer.class);

    private final RabbitTemplate rabbitTemplate;

    public RequestProducer(final RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendRequestMessage(RequestMessage requestMessage) {
        log.info("Sending message {}",NebulaConstant.REQUEST_QUEUE_NAME);
        rabbitTemplate.convertAndSend(NebulaConstant.REQUEST_EXCHANGE_NAME, NebulaConstant.REQUEST_ROUTING_KEY, requestMessage);
    }

}
