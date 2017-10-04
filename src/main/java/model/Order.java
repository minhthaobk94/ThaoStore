package model;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class Order {
    private int id;
    private Customer customer;
    private String shipping_address;
    private double total;
    private String note;
    private Timestamp created;

    public Order(int id, Customer customer, String shipping_address, double total, String note, Timestamp created) {
        this.id = id;
        this.customer = customer;
        this.shipping_address = shipping_address;
        this.total = total;
        this.note = note;
        this.created = created;
    }

    public Order(Customer customer, String shipping_address, double total, String note, Timestamp created) {
        this.customer = customer;
        this.shipping_address = shipping_address;
        this.total = total;
        this.note = note;
        this.created = created;
    }

    public Order() {
    }
}
