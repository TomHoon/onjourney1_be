package com.on.journey.order.entity;

import com.on.journey.customer.entity.Customer;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "orders")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @Column(name = "order_name")
    private String orderName;

    @Column(name = "order_price")
    private Integer orderPrice;

    public Order(Customer customer, String orderName, Integer orderPrice) {
        this.customer = customer;
        this.orderName = orderName;
        this.orderPrice = orderPrice;
    }
}