package com.on.journey.photo.entity;


import com.on.journey.customer.entity.Customer;
import com.on.journey.product.entity.Product;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "photos")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Photo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "photo_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @Column(name = "photo_origin_name")
    private String originName;

    @Column(name = "photo_show_name")
    private String showName;

    @Column(name = "photo_path")
    private String path;

    @Column(name = "photo_show_file_name")
    private String showFileName;

    public Photo(Product product, Customer customer, String originName, String showName, String path, String showFileName) {
        this.product = product;
        this.customer = customer;
        this.originName = originName;
        this.showName = showName;
        this.path = path;
        this.showFileName = showFileName;
    }
}