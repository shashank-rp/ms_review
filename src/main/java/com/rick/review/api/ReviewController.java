package com.rick.review.api;

import com.rick.review.dto.ReviewDto;
import com.rick.review.service.ReviewService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.UUID;
@Controller
@Api(tags = "Review")
public class ReviewController implements ReviewApi{

    @Autowired
    private ReviewService reviewService;

    @Override
    public ResponseEntity<List<ReviewDto>> createMultipleReviews(UUID tenantId, List<ReviewDto> reviewDto) throws Exception {
        return new ResponseEntity<>(reviewService.createMultipleReviews(tenantId, reviewDto), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<ReviewDto>> getAllReviews(UUID tenantId) throws Exception {
        return new ResponseEntity<>(reviewService.getAllReviews(tenantId),HttpStatus.OK);
    }
}
