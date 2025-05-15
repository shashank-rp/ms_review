package com.rick.review.service.transformer;

import com.rick.review.dto.ReviewDto;
import com.rick.review.dto.UpsertInfoDto;
import com.rick.review.entity.BaseEntity;
import com.rick.review.entity.Review;
import com.rick.review.exception.CustomizedException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.UUID;

import static java.util.Objects.isNull;

@Component
public class ReviewDtoToEntityTransformer {

    public Review convertReviewDtoToEntity(UUID tenantId, ReviewDto reviewDto) {
        Review review = new Review();
        review.setRating(reviewDto.getRating());
        review.setComment(reviewDto.getComment());
        review.setTenantId(tenantId);
        convertUpsertInfoToBaseEntity(review, reviewDto.getUpsertInfo());
        return review;
    }

    private <R extends BaseEntity> R convertUpsertInfoToBaseEntity(R data, UpsertInfoDto upsertInfoDto){
        if(isNull(upsertInfoDto)){
            throw new CustomizedException("UpsertInfo must not be null","Please Enter Valid details", HttpStatus.BAD_REQUEST);
        }
        if(isNull(upsertInfoDto.getCreatedBy())){
            throw new CustomizedException("createdBy must not be null","Please Enter Valid details", HttpStatus.BAD_REQUEST);
        }

        try{
            data.setCreatedBy(upsertInfoDto.getCreatedBy());
            data.setCreatedAt(upsertInfoDto.getCreatedAt() == null ? Instant.now(): Instant.parse(upsertInfoDto.getCreatedAt()));
        }catch(Exception e){
            throw new CustomizedException("createdAt and modifiedAt should be in format of YYYY-MM-DDTHH:mm:SS.MSZ","Please Enter Valid details", HttpStatus.BAD_REQUEST);
        }
        return data;
    }
}
