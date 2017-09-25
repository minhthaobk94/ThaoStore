package main;


import dao.iml.CustomerDAOIml;
import dao.iml.OrderDAOIml;
import model.Order;

import java.sql.Timestamp;

public class Main {
    public static void main(String[] args) {
        OrderDAOIml orderDAOIml = new OrderDAOIml();
        CustomerDAOIml customerDAOIml = new CustomerDAOIml();
        Timestamp timestamp = new Timestamp(2007,3,4,12,55,10, 1);
        Order order = new Order(10, customerDAOIml.getCustomer(4), "quang nam", 12254.9, "noted", timestamp);
        System.out.println(orderDAOIml.updateOrder(order));

    }
}
