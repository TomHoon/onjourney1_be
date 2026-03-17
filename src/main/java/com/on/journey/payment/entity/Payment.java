package com.on.journey.payment.entity;

import com.on.journey.order.entity.Order;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "payments")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    @Column(name = "payment_price", nullable = false)
    private Integer price;

    @Column(name = "payment_name")
    private String name;

    public Payment(Order order, Integer price, String name) {
        this.order = order;
        this.price = price;
        this.name = name;
    }
}