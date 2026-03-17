package com.on.journey.review.entity;

import com.on.journey.orderitem.entity.OrderItem;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "review")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_item_id", nullable = false, unique = true)
    private OrderItem orderItem;

    @Column(name = "rating")
    private Integer rating;

    @Column(name = "review_text")
    private String reviewText;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    public Review(OrderItem orderItem, Integer rating, String reviewText) {
        this.orderItem = orderItem;
        this.rating = rating;
        this.reviewText = reviewText;
        this.createdAt = LocalDateTime.now();
    }
}