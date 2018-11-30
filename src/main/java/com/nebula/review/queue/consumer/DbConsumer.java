package com.nebula.review.queue.consumer;

import com.nebula.review.common.NebulaConstant;
import com.nebula.review.common.SingletonHolder;
import com.nebula.review.model.NotificationRequest;
import com.nebula.review.model.RequestMessage;
import com.nebula.review.repo.intrface.IAdventureWorks;
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
public class DbConsumer {

    @Autowired
    IAdventureWorks adventureWorks;

    private static final Logger log = LoggerFactory.getLogger(RequestConsumer.class);

    private final RabbitTemplate rabbitTemplate;

    public DbConsumer(final RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Bean
    public TopicExchange emailExchange() {
        return new TopicExchange(NebulaConstant.EMAIL_EXCHANGE_NAME);
    }

    @Bean
    public Queue emailQueueName() {
        return new Queue(NebulaConstant.EMAIL_QUEUE_NAME);
    }

    @Bean
    public Binding declareEmailBinding() {
        return BindingBuilder.bind(emailQueueName()).to(emailExchange()).with(NebulaConstant.EMAIL_ROUTING_KEY);
    }


    @RabbitListener(queues = NebulaConstant.DB_QUEUE_NAME)
    public void receiveMessage(final RequestMessage message) {
        log.info("Received {} : {}", NebulaConstant.DB_QUEUE_NAME, message.toString());
        adventureWorks.insertReview(message);
        NotificationRequest request = new NotificationRequest.NotificationRequestBuilder(message.getName(),Boolean.TRUE,message.getEmail()).builder();
        SingletonHolder.getInstance().getReviewedMessageHashMap().put(message.getReviewId(), request);
    }
}
