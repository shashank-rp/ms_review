package com.rick.review.service;

import com.rick.review.dto.ReviewDto;
import com.rick.review.dto.RvMultiplePatchRequestDto;

import java.util.List;
import java.util.UUID;

public interface ReviewService {
    List<ReviewDto> createMultipleReviews(UUID tenantId, List<ReviewDto> reviewDto);
    /**
     *  This method is used for get multiple reviews
     * @param tenantId unique id for user
     * @return List<ReviewDto>
     *
     */
    List<ReviewDto> getAllReviews(UUID tenantId);

    /**
     *  This method is used for update multiple reviews
     * @param tenantId unique id for user
     * @param rvMultiplePatchRequestDto
     * @return List<ReviewDto>
     *
     */
    List<ReviewDto> updateMultipleReviews(UUID tenantId, List<RvMultiplePatchRequestDto> rvMultiplePatchRequestDto);
}
