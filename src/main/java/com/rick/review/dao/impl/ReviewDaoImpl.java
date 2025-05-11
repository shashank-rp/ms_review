package com.rick.review.dao.impl;

import com.rick.review.dao.ReviewDao;
import com.rick.review.entity.Review;
import com.rick.review.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ReviewDaoImpl implements ReviewDao {
    @Autowired
    private ReviewRepository reviewRepository;
    @Override
    public List<Review> createListReview(List<Review> reviewList) {
        return reviewRepository.saveAll(reviewList);
    }
}
