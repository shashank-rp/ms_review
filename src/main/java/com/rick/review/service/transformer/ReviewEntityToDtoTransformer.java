package com.rick.review.service.transformer;

import com.rick.review.dto.ReviewDto;
import com.rick.review.dto.UpsertInfoDto;
import com.rick.review.dto.UserDataDto;
import com.rick.review.entity.Review;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static java.util.Objects.nonNull;

@Component
public class ReviewEntityToDtoTransformer {

    public List<ReviewDto> convertReviewEntityToDto(UUID tenantId, List<Review> reviewList) {
        List<ReviewDto> reviewDtoList = new ArrayList<>();
        for(Review review: reviewList){
            ReviewDto reviewDto = new ReviewDto();
            reviewDto.setRvId(review.getRvId());
            if(nonNull(review.getComment())) reviewDto.setComment(review.getComment());
            reviewDto.setRating(review.getRating());
            UpsertInfoDto upsertInfoDto = new UpsertInfoDto();
            upsertInfoDto.setCreatedAt(review.getCreatedAt().toString());
            upsertInfoDto.setCreatedBy(review.getCreatedBy());
            if(nonNull(review.getModifiedAt())) upsertInfoDto.setModifiedAt(review.getModifiedAt().toString());
            if(nonNull(review.getModifiedBy())) upsertInfoDto.setModifiedBy(review.getModifiedBy());
            reviewDto.setUpsertInfo(upsertInfoDto);
            UserDataDto userDataDto = new UserDataDto();
            userDataDto.setUserId(tenantId);
            reviewDto.setTenantId(userDataDto);
            reviewDtoList.add(reviewDto);
        }
        return reviewDtoList;
    }
}
