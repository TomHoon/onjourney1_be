package com.on.journey.seller.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "seller")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Seller {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seller_id")
    private Long id;

    @Column(name = "seller_name", nullable = false)
    private String name;

    @Column(name = "seller_phone")
    private String phone;

    @Column(name = "seller_email")
    private String email;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    public Seller(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.createdAt = LocalDateTime.now();
    }
}