package com.nebula.review.common;


import com.google.gson.Gson;
import com.nebula.review.model.NotificationRequest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public final class SingletonHolder {

    private static SingletonHolder instance = null;
    private static ConcurrentHashMap<String ,NotificationRequest> archievedMessages = null;
    private static Gson gsonInstance = null;

    private AtomicInteger atomicIntegerSuccess = new AtomicInteger(0);
    private AtomicInteger atomicIntegerFail = new AtomicInteger(0);

    private SingletonHolder() {
    }

    public static SingletonHolder getInstance() {
        if (instance == null) {
            instance = new SingletonHolder();
        }
        return instance;
    }

    public ConcurrentHashMap<String ,NotificationRequest> getReviewedMessageHashMap(){
        if (archievedMessages == null){
            archievedMessages = new ConcurrentHashMap<>();
        }
        return archievedMessages;
    }

    public Gson getGson(){
        if (gsonInstance == null){
            gsonInstance = new Gson();
        }
        return gsonInstance;
    }

    public AtomicInteger getSuccess(){
        return atomicIntegerSuccess;
    }

    public AtomicInteger getFail(){
        return atomicIntegerFail;
    }


    public String generateReviewID(){
        long number = (long) Math.floor(Math.random() * 9000L) + 100L;
        return String.valueOf(number);
    }


}
