package com.rick.review.dao;

import com.rick.review.entity.Review;

import java.util.List;

public interface ReviewDao {
    List<Review> createListReview(List<Review> reviewList);
}
