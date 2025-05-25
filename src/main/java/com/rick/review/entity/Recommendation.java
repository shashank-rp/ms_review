package com.rick.review.entity;

import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "recommendation")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Recommendation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rdId;

    @Column(nullable = false,name = "priority")
    private Integer priority;

    @Column(nullable = false,name = "tenantId")
    private UUID tenantId;

    @OneToOne
    @JoinColumn(name = "productId",referencedColumnName = "productId")
    private Product product;
}
