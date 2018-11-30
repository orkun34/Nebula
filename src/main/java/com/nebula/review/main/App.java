package com.nebula.review.main;

import com.nebula.review.common.NebulaConstant;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@ComponentScan(basePackages = "com.nebula.review")
@EnableJpaRepositories("com.nebula.review.repo")
@EntityScan("com.nebula.review.model.db")
public class App {

    @Bean
    public TopicExchange requestExchange() {
        return new TopicExchange(NebulaConstant.REQUEST_EXCHANGE_NAME);
    }

    @Bean
    public Queue requestQueueName() {
        return new Queue(NebulaConstant.REQUEST_QUEUE_NAME);
    }

    @Bean
    public Binding declareRequestBinding() {
        return BindingBuilder.bind(requestQueueName()).to(requestExchange()).with(NebulaConstant.REQUEST_ROUTING_KEY);
    }

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

}
