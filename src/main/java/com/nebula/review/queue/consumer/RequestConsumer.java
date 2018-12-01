package com.nebula.review.queue.consumer;

import com.nebula.review.common.NebulaConstant;
import com.nebula.review.model.RequestMessage;
import com.nebula.review.service.intrface.IValidation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class RequestConsumer {


    @Autowired
    IValidation validation;

    private static final Logger log = LoggerFactory.getLogger(RequestConsumer.class);

    private final RabbitTemplate rabbitTemplate;

    public RequestConsumer(final RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Bean
    public TopicExchange dbExchange() {
        return new TopicExchange(NebulaConstant.DB_EXCHANGE_NAME);
    }

    @Bean
    public Queue dbQueueName() {
        return new Queue(NebulaConstant.DB_QUEUE_NAME);
    }

    @Bean
    public Binding declareDbBinding() {
        return BindingBuilder.bind(dbQueueName()).to(dbExchange()).with(NebulaConstant.DB_ROUTING_KEY);
    }

    @RabbitListener(queues = NebulaConstant.REQUEST_QUEUE_NAME)
    public void receiveRequestMessage(final RequestMessage message) {

        log.info("Received {} : {}", NebulaConstant.REQUEST_QUEUE_NAME, message.toString());

        if (validation.isAppropriate(message, message.getReviewId())) {
            log.info("Sending message {}", NebulaConstant.DB_QUEUE_NAME);
            rabbitTemplate.convertAndSend(NebulaConstant.DB_EXCHANGE_NAME, NebulaConstant.DB_ROUTING_KEY, message);
        }

    }
}
