package com.rick.review.service.impl;

import com.rick.review.dto.ReviewDto;
import com.rick.review.exception.CustomizedException;
import com.rick.review.service.ReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

import static java.util.Objects.isNull;

@Component
public class ReviewServiceImpl implements ReviewService {
    @Override
    public List<ReviewDto> createMultipleReviews(UUID tenantId, List<ReviewDto> reviewDto) {
        reviewValidations(reviewDto);
        return null;
    }

    private void reviewValidations(List<ReviewDto> reviewDto) {
        if(isNull(reviewDto)){
            throw new CustomizedException("Dto should not be empty","Please enter valid details", HttpStatus.BAD_REQUEST);
        }
    }
}
