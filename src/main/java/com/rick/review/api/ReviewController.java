package com.rick.review.api;

import com.rick.review.dto.ReviewDto;
import com.rick.review.dto.RvMultiplePatchRequestDto;
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

    /**
     *  This method is used for creation of multiple reviews
     * @param tenantId unique id for user
     * @param reviewDto
     * @return List<ReviewDto>
     *
     */
    @Override
    public ResponseEntity<List<ReviewDto>> createMultipleReviews(UUID tenantId, List<ReviewDto> reviewDto) throws Exception {
        return new ResponseEntity<>(reviewService.createMultipleReviews(tenantId, reviewDto), HttpStatus.OK);
    }

    /**
     *  This method is used for get multiple reviews
     * @param tenantId unique id for user
     * @return List<ReviewDto>
     *
     */
    @Override
    public ResponseEntity<List<ReviewDto>> getAllReviews(UUID tenantId) throws Exception {
        return new ResponseEntity<>(reviewService.getAllReviews(tenantId),HttpStatus.OK);
    }

    /**
     *  This method is used for update multiple reviews
     * @param tenantId unique id for user
     * @param rvMultiplePatchRequestDto
     * @return List<ReviewDto>
     *
     */
    @Override
    public ResponseEntity<List<ReviewDto>> updateMultipleReviews(UUID tenantId, List<RvMultiplePatchRequestDto> rvMultiplePatchRequestDto) throws Exception {
        return new ResponseEntity<>(reviewService.updateMultipleReviews(tenantId, rvMultiplePatchRequestDto),HttpStatus.OK);
    }
}
