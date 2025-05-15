package com.rick.review.repository;

import com.rick.review.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ReviewRepository extends JpaRepository<Review,Long> {
    @Query("Select r from Review r where r.tenantId = :tenantId")
    List<Review> findAllReviewByTenantId(@Param("tenantId") UUID tenantId);
}
