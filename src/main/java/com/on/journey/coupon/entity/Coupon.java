package com.on.journey.coupon.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "coupon")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Coupon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "coupon_id")
    private Long id;

    @Column(name = "coupon_name")
    private String name;

    @Column(name = "discount_amount")
    private Integer discountAmount;

    @Column(name = "expired_at")
    private LocalDateTime expiredAt;

    public Coupon(String name, Integer discountAmount, LocalDateTime expiredAt) {
        this.name = name;
        this.discountAmount = discountAmount;
        this.expiredAt = expiredAt;
    }
}