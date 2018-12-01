package com.nebula.review.common;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
@ConfigurationProperties("nebula")
public class NebulaProp {

    private String nonValids;

    public String getNonValids() {
        return nonValids;
    }

    public void setNonValids(String nonValids) {
        this.nonValids = nonValids;
    }

    public List<String> getNonValidList(){
        return Arrays.asList(getNonValids().split(","));
    }



}
