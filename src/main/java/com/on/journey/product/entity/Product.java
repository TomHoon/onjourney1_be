package com.on.journey.product.entity;

import com.on.journey.seller.entity.Seller;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "products")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;

    @Column(name = "product_name", nullable = false)
    private String name;

    @Column(name = "product_type")
    private String type;

    @Column(name = "product_price", nullable = false)
    private Integer price;

    @Column(name = "product_slice")
    private String slice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seller_id", nullable = false)
    private Seller seller;

    public Product(String name, String type, Integer price, String slice, Seller seller) {
        this.name = name;
        this.type = type;
        this.price = price;
        this.slice = slice;
        this.seller = seller;
    }
}