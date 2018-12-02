package com.nebula.review.repo.intrface;

import com.nebula.review.model.RequestMessage;
import com.nebula.review.model.db.ProductReview;

import java.util.Arrays;
import java.util.List;

public interface IAdventureWorks {

    void insertReview(RequestMessage message);

    List<ProductReview> listProductReviews();

    public static void main(String[] args) {
        String[] review = "I need to buy better quality".split(" ");
        List<String> prop = Arrays.asList("nee", "pee", "tea");

        boolean match = false;
        for (String s : prop) {
             for (String rS : Arrays.asList(review))
            if(rS.equals(s)){
                match = true;
                break;
            }
        }

        System.out.println(match);
    }

}
