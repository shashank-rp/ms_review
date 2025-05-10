package com.rick.review.service;

import com.rick.review.dto.ReviewDto;

import java.util.List;
import java.util.UUID;

public interface ReviewService {
    List<ReviewDto> createMultipleReviews(UUID tenantId, List<ReviewDto> reviewDto);
}
