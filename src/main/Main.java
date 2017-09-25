package main;


import dao.iml.OrderDAOIml;
import dao.iml.OrderItemDAOIml;
import dao.iml.ProductDAOIml;
import model.OrderItem;

public class Main {
    public static void main(String[] args) {
//        OrderDAOIml orderDAOIml = new OrderDAOIml();
//        CustomerDAOIml customerDAOIml = new CustomerDAOIml();
//        Timestamp timestamp = new Timestamp(2007,3,4,12,55,10, 1);
//        Order order = new Order(10, customerDAOIml.getCustomer(4), "quang nam", 12254.9, "noted", timestamp);
//        System.out.println(orderDAOIml.updateOrder(order));

//        ProductDAOIml productDAOIml = new ProductDAOIml();
//        CategoryDAOIml categoryDAOIml = new CategoryDAOIml();
//        Product product = new Product(3, categoryDAOIml.getCategory(3), "thao", "gjae", "jwjkrtgei.jpg", 32856);
//        System.out.println(productDAOIml.deleteProduct(product));

        OrderItemDAOIml orderItemDAOIml = new OrderItemDAOIml();
        ProductDAOIml productDAOIml = new ProductDAOIml();
        OrderDAOIml orderDAOIml = new OrderDAOIml();
        OrderItem orderItem = new OrderItem(orderDAOIml.getOrder(10),productDAOIml.getProduct(5));
        System.out.println(orderItemDAOIml.deleteOrderItem(orderItem));

    }
}
