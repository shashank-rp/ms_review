package com.rick.review.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "product")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product extends BaseEntity{
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Type(type = "pg-uuid")
    private UUID productId;

    @Column(nullable = false,name = "product_name")
    private String productName;

    @Column(name = "origin")
    private String origin;

    @Column(nullable = false,name = "type")
    private String type;

    @Column(nullable = false,name = "tenantId")
    private UUID tenantId;

    @Column(nullable = false,name = "price")
    private Double price;

    @OneToMany(mappedBy = "product",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Review> reviews;

    @OneToOne
    @JoinColumn(name = "rdId",referencedColumnName = "rdId")
    private Recommendation recommendation;

}
