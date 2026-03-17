package com.on.journey.settlement.entity;

import com.on.journey.orderitem.entity.OrderItem;
import com.on.journey.seller.entity.Seller;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "settlement")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Settlement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "settlement_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_item_id", nullable = false)
    private OrderItem orderItem;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seller_id", nullable = false)
    private Seller seller;

    @Column(name = "settlement_amount", nullable = false)
    private Integer amount;

    @Column(name = "settlement_status")
    private String status;

    @Column(name = "settled_at")
    private LocalDateTime settledAt;

    public Settlement(OrderItem orderItem, Seller seller, Integer amount, String status, LocalDateTime settledAt) {
        this.orderItem = orderItem;
        this.seller = seller;
        this.amount = amount;
        this.status = status;
        this.settledAt = settledAt;
    }
}