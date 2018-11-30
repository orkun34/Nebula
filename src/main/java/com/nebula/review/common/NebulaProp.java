package com.nebula.review.common;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
@ConfigurationProperties("nebula")
public class NebulaProp {


    private String nonValidList;

    public List<String> getNonValidList() {
        return Arrays.asList(nonValidList.split(","));
    }

}
