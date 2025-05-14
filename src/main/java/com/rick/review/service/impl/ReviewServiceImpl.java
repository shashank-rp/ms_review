package com.rick.review.service.impl;

import com.rick.review.dao.ReviewDao;
import com.rick.review.dto.ReviewDto;
import com.rick.review.entity.Review;
import com.rick.review.exception.CustomizedException;
import com.rick.review.service.ReviewService;
import com.rick.review.service.transformer.ReviewDtoToEntityTransformer;
import com.rick.review.service.transformer.ReviewEntityToDtoTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static java.util.Objects.isNull;

@Component
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewDtoToEntityTransformer reviewDtoToEntityTransformer;

    @Autowired
    private ReviewEntityToDtoTransformer reviewEntityToDtoTransformer;

    @Autowired
    private ReviewDao reviewDao;
    @Override
    public List<ReviewDto> createMultipleReviews(UUID tenantId, List<ReviewDto> reviewDtos) {
        List<Review> reviewList = new ArrayList<>();
        reviewsValidations(reviewDtos);
        for(ReviewDto reviewDto: reviewDtos){
            reviewValidations(reviewDto);
            Review review = reviewDtoToEntityTransformer.convertReviewDtoToEntity(tenantId,reviewDto);
            reviewList.add(review);
        }
        reviewList = reviewDao.createListReview(reviewList);
        return reviewEntityToDtoTransformer.convertReviewEntityToDto(tenantId,reviewList);
    }

    @Override
    public List<ReviewDto> getAllReviews(UUID tenantId) {
        List<Review> reviewList = reviewDao.getAllReviews(tenantId);
        return reviewEntityToDtoTransformer.convertReviewEntityToDto(tenantId,reviewList);
    }

    private void reviewsValidations(List<ReviewDto> reviewDto) {
        if(isNull(reviewDto)){
            throw new CustomizedException("Dtos should not be empty","Please enter valid details", HttpStatus.BAD_REQUEST);
        }
    }

    private void reviewValidations(ReviewDto reviewDto){
        if(isNull(reviewDto)){
            throw new CustomizedException("Dto should not be empty","Please enter valid details", HttpStatus.BAD_REQUEST);
        }

        if(isNull(reviewDto.getRating())){
            throw new CustomizedException("rating should not be empty","Please enter valid details", HttpStatus.BAD_REQUEST);
        }
    }
}
