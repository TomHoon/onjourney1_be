CREATE TABLE customers (
    customer_id BIGINT NOT NULL AUTO_INCREMENT,
    customer_name VARCHAR(100) NOT NULL,
    customer_phone VARCHAR(20),
    joined_date DATETIME,
    PRIMARY KEY (customer_id)
);

CREATE TABLE seller (
    seller_id BIGINT NOT NULL AUTO_INCREMENT,
    seller_name VARCHAR(200) NOT NULL,
    seller_phone VARCHAR(20),
    seller_email VARCHAR(200),
    created_at DATETIME,
    PRIMARY KEY (seller_id)
);

CREATE TABLE products (
    product_id BIGINT NOT NULL AUTO_INCREMENT,
    product_name VARCHAR(200) NOT NULL,
    product_type VARCHAR(50),
    product_price INT NOT NULL,
    product_slice VARCHAR(20),
    seller_id BIGINT NOT NULL,
    PRIMARY KEY (product_id),
    CONSTRAINT FK_product_seller FOREIGN KEY (seller_id)
        REFERENCES seller(seller_id)
);

CREATE TABLE photos (
    photo_id BIGINT NOT NULL AUTO_INCREMENT,
    product_id BIGINT NOT NULL,
    customer_id BIGINT NOT NULL,
    photo_origin_name VARCHAR(255),
    photo_show_name VARCHAR(255),
    photo_path VARCHAR(500),
    photo_show_file_name VARCHAR(255),
    PRIMARY KEY (photo_id),
    CONSTRAINT FK_photo_product FOREIGN KEY (product_id)
        REFERENCES products(product_id),
    CONSTRAINT FK_photo_customer FOREIGN KEY (customer_id)
        REFERENCES customers(customer_id)
);

CREATE TABLE orders (
    order_id BIGINT NOT NULL AUTO_INCREMENT,
    customer_id BIGINT NOT NULL,
    order_name VARCHAR(200),
    order_price INT,
    PRIMARY KEY (order_id),
    CONSTRAINT FK_orders_customer FOREIGN KEY (customer_id)
        REFERENCES customers(customer_id)
);

CREATE TABLE order_items (
    order_item_id BIGINT NOT NULL AUTO_INCREMENT,
    order_id BIGINT NOT NULL,
    product_id BIGINT NOT NULL,
    photo_id BIGINT NOT NULL,
    order_item_quantity INT,
    PRIMARY KEY (order_item_id),
    CONSTRAINT FK_orderitem_order FOREIGN KEY (order_id)
        REFERENCES orders(order_id),
    CONSTRAINT FK_orderitem_product FOREIGN KEY (product_id)
        REFERENCES products(product_id),
    CONSTRAINT FK_orderitem_photo FOREIGN KEY (photo_id)
        REFERENCES photos(photo_id)
);

CREATE TABLE payments (
    payment_id BIGINT NOT NULL AUTO_INCREMENT,
    order_id BIGINT NOT NULL,
    payment_price INT NOT NULL,
    payment_name VARCHAR(100),
    PRIMARY KEY (payment_id),
    CONSTRAINT FK_payment_order FOREIGN KEY (order_id)
        REFERENCES orders(order_id)
);

CREATE TABLE shipment (
    shipment_id BIGINT NOT NULL AUTO_INCREMENT,
    order_id BIGINT NOT NULL,
    shipment_status VARCHAR(50),
    shipment_company VARCHAR(100),
    tracking_number VARCHAR(200),
    shipped_at DATETIME,
    PRIMARY KEY (shipment_id),
    CONSTRAINT FK_shipment_order FOREIGN KEY (order_id)
        REFERENCES orders(order_id)
);

CREATE TABLE order_status (
    order_status_id BIGINT NOT NULL AUTO_INCREMENT,
    order_id BIGINT NOT NULL,
    status VARCHAR(50),
    status_changed_at DATETIME,
    PRIMARY KEY (order_status_id),
    CONSTRAINT FK_orderstatus_order FOREIGN KEY (order_id)
        REFERENCES orders(order_id)
);

CREATE TABLE review (
    review_id BIGINT NOT NULL AUTO_INCREMENT,
    rating INT,
    review_text TEXT,
    created_at DATETIME,
    order_item_id BIGINT NOT NULL UNIQUE,
    PRIMARY KEY (review_id),
    CONSTRAINT FK_review_orderitem FOREIGN KEY (order_item_id)
        REFERENCES order_items(order_item_id)
);

CREATE TABLE settlement (
    settlement_id BIGINT NOT NULL AUTO_INCREMENT,
    settlement_amount INT NOT NULL,
    settlement_status VARCHAR(20),
    settled_at DATETIME,
    order_item_id BIGINT NOT NULL,
    seller_id BIGINT NOT NULL,
    PRIMARY KEY (settlement_id),
    CONSTRAINT FK_settlement_orderitem FOREIGN KEY (order_item_id)
        REFERENCES order_items(order_item_id),
    CONSTRAINT FK_settlement_seller FOREIGN KEY (seller_id)
        REFERENCES seller(seller_id)
);

CREATE TABLE cart (
    cart_id BIGINT NOT NULL AUTO_INCREMENT,
    quantity INT,
    created_at DATETIME,
    product_id BIGINT NOT NULL,
    customer_id BIGINT NOT NULL,
    PRIMARY KEY (cart_id),
    CONSTRAINT FK_cart_product FOREIGN KEY (product_id)
        REFERENCES products(product_id),
    CONSTRAINT FK_cart_customer FOREIGN KEY (customer_id)
        REFERENCES customers(customer_id)
);

CREATE TABLE coupon (
    coupon_id BIGINT NOT NULL AUTO_INCREMENT,
    coupon_name VARCHAR(200),
    discount_amount INT,
    expired_at DATETIME,
    PRIMARY KEY (coupon_id)
);