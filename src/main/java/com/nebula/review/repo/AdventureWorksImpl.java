package com.nebula.review.repo;

import com.nebula.review.model.RequestMessage;
import com.nebula.review.model.db.ProductReview;
import com.nebula.review.repo.intrface.IAdventureWorks;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AdventureWorksImpl implements IAdventureWorks {

    private static final Logger log = LoggerFactory.getLogger(AdventureWorksImpl.class);

    @Autowired
    AdventureWorksRepo repo;

    @Override
    public void insertReview(RequestMessage message) {
        log.info("<AdventureWorksImpl> reached with values name: {}, email: {}, productId: {}",message.getName(),message.getEmail(),message.getProductId());
        ProductReview productReview = new ProductReview(Long.valueOf(message.getProductId()),message.getName(),new Date(),message.getEmail(),4L,message.getReview(),new Date());
        try {
            repo.saveAndFlush(productReview);
        } catch (DataAccessException ex) {
            log.error("Exception happened : {}", ex);
        }

    }

}
