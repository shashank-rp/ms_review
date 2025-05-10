package com.rick.review.api;

import com.rick.review.dto.ReviewDto;
import com.rick.review.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public class ReviewController implements ReviewApi{

    @Autowired
    private ReviewService reviewService;

    @Override
    public ResponseEntity<List<ReviewDto>> createMultipleReviews(UUID tenantId, List<ReviewDto> reviewDto) throws Exception {
        return new ResponseEntity<>(reviewService.createMultipleReviews(tenantId, reviewDto), HttpStatus.OK);
    }
}
