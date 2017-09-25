package model;

import lombok.Data;

@Data
public class OrderItem {
    private Order order;
    private Product product;

    public OrderItem(Product product) {
        this.product = product;
    }

    public OrderItem(Order order, Product product) {
        this.order = order;
        this.product = product;
    }

    public OrderItem() {
    }
}
