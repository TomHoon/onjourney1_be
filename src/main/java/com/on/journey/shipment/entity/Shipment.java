package com.on.journey.shipment.entity;

import com.on.journey.order.entity.Order;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "shipment")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Shipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shipment_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    @Column(name = "shipment_status")
    private String status;

    @Column(name = "shipment_company")
    private String company;

    @Column(name = "tracking_number")
    private String trackingNumber;

    @Column(name = "shipped_at")
    private LocalDateTime shippedAt;

    public Shipment(Order order, String status, String company, String trackingNumber, LocalDateTime shippedAt) {
        this.order = order;
        this.status = status;
        this.company = company;
        this.trackingNumber = trackingNumber;
        this.shippedAt = shippedAt;
    }
}