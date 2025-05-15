package com.rick.review.service.impl;

import com.rick.review.dao.ReviewDao;
import com.rick.review.dto.ReviewDto;
import com.rick.review.dto.RvMultiplePatchRequestDto;
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

/**
 * @author Shashank
 * @version 1
 * */
@Component
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewDtoToEntityTransformer reviewDtoToEntityTransformer;

    @Autowired
    private ReviewEntityToDtoTransformer reviewEntityToDtoTransformer;

    @Autowired
    private ReviewDao reviewDao;

    /**
     * This Method Returns List of Review
     *
     * @param tenantId unique id for user
     * @param reviewDtos list of review dto for inserting
     * @return List<ReviewDto>
     * */
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

    /**
     *  This method is used for get multiple reviews
     * @param tenantId unique id for user
     * @return List<ReviewDto>
     *
     */
    @Override
    public List<ReviewDto> getAllReviews(UUID tenantId) {
        List<Review> reviewList = reviewDao.getAllReviews(tenantId);
        return reviewEntityToDtoTransformer.convertReviewEntityToDto(tenantId,reviewList);
    }

    /**
     *  This method is used for update multiple reviews
     * @param tenantId unique id for user
     * @param rvMultiplePatchRequestDto
     * @return List<ReviewDto>
     *
     */
    @Override
    public List<ReviewDto> updateMultipleReviews(UUID tenantId, List<RvMultiplePatchRequestDto> rvMultiplePatchRequestDto) {
        return null;
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
