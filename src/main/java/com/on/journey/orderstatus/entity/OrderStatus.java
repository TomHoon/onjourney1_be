package com.on.journey.orderstatus.entity;

import com.on.journey.order.entity.Order;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "order_status")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OrderStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_status_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    @Column(name = "status")
    private String status;

    @Column(name = "status_changed_at")
    private LocalDateTime statusChangedAt;

    public OrderStatus(Order order, String status, LocalDateTime statusChangedAt) {
        this.order = order;
        this.status = status;
        this.statusChangedAt = statusChangedAt;
    }
}