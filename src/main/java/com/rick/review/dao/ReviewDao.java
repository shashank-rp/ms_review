package com.rick.review.dao;

import com.rick.review.entity.Review;

import java.util.List;
import java.util.UUID;

public interface ReviewDao {
    List<Review> createListReview(List<Review> reviewList);

    List<Review> getAllReviews(UUID tenantId);
}
