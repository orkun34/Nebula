package com.nebula.review.queue;

import com.nebula.review.model.RequestMessage;

public abstract class Notification {

    void sendEmail(Boolean reviewResult,RequestMessage message){
        System.out.println(message.getName()+" used "+reviewResult+" review ");
    }
}
