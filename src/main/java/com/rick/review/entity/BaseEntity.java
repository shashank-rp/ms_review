package com.rick.review.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntity {

    @Column(name = "created_by",updatable = false,nullable = false)
    protected UUID createdBy;

    @Column(name = "created_at")
    protected Instant createdAt;

    @Column(name = "modified_by")
    protected UUID modifiedBy;

    @Column(name = "modified_at")
    protected Instant modifiedAt;

    @Column
    @Version
    protected int version;
}
