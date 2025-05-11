package com.rick.review.entity;

import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "review")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Review extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rvId")
    private Long rvId;

    @Column(nullable = false,name = "rating")
    private String rating;

    @Column(nullable = false,name = "tenantId")
    private UUID tenantId;

    @Column(name = "comment")
    private String comment;

}
