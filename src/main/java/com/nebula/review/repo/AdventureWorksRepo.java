package com.nebula.review.repo;

import com.nebula.review.model.db.ProductReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdventureWorksRepo extends JpaRepository<ProductReview,Long> {
}
