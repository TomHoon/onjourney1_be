package com.on.journey.customer.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "customers")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Long id;

    @Column(name = "customer_name", nullable = false)
    private String name;

    @Column(name = "customer_phone")
    private String phone;

    @Column(name = "joined_date")
    private LocalDateTime joinedDate;

    public Customer(String name, String phone) {
        this.name = name;
        this.phone = phone;
        this.joinedDate = LocalDateTime.now();
    }
}