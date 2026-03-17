package com.on.journey.orderitem.entity;

import com.on.journey.order.entity.Order;
import com.on.journey.photo.entity.Photo;
import com.on.journey.product.entity.Product;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "order_items")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_item_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "photo_id", nullable = false)
    private Photo photo;

    @Column(name = "order_item_quantity")
    private Integer quantity;

    public OrderItem(Order order, Product product, Photo photo, Integer quantity) {
        this.order = order;
        this.product = product;
        this.photo = photo;
        this.quantity = quantity;
    }
}