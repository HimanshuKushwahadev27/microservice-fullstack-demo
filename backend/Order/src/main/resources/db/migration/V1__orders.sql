CREATE TABLE orders (
    id BIGSERIAL PRIMARY KEY,

    order_number VARCHAR(50) ,
    price_paid DECIMAL(10, 2) ,
    quantity INT ,
    sku_code VARCHAR(100) ,

    CONSTRAINT uk_orders_order_number UNIQUE (order_number)
);