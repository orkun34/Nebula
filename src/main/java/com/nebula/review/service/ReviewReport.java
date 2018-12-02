package com.nebula.review.service;

import com.nebula.review.common.SingletonHolder;
import com.nebula.review.model.NotificationRequest;
import com.nebula.review.repo.intrface.IAdventureWorks;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.Map;

@Service
public class ReviewReport {

    private static final Logger log = LoggerFactory.getLogger(ReviewReport.class);

    @Autowired
    IAdventureWorks adventureWorks;

    @Scheduled(fixedDelay = 10000L)
    public void generateReport() {


        long countSuccess = SingletonHolder.getInstance().getSuccess().get();
        long countFail = SingletonHolder.getInstance().getFail().get();

        if (countFail + countSuccess != 0) {
            log.info("Reporting channel size");
            log.info("Total success reviews :{} , Total failed reviews :{} , Average success rate :{}", countSuccess, countFail, ((100 * (countSuccess)) / (countFail + countSuccess)));
        }

    }

    @Scheduled(fixedDelay = 5000L)
    public void notifyReviewer() {

        Iterator<Map.Entry<String, NotificationRequest>> iterator = SingletonHolder.getInstance().getReviewedMessageHashMap().entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, NotificationRequest> entry = iterator.next();
            log.info("Dear {} , your review which was send via {} has been {}", entry.getValue().getName(), entry.getValue().getEmail(), Boolean.valueOf(entry.getValue().getIsValid()) ? "ACCEPTED" : "REJECTED");
            if (entry.getValue().getIsValid().equals(Boolean.TRUE)) {
                SingletonHolder.getInstance().getSuccess().incrementAndGet();
            } else {
                SingletonHolder.getInstance().getFail().incrementAndGet();
            }
            iterator.remove();
        }
    }

}
