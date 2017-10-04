package dao;

import model.Order;

import java.util.List;

public interface OrderDAO {
    List<Order> getAllOrders();

    Order getOrder(int id);

    int addOrder(Order order);

    int updateOrder(Order order);

    int deleteOrder(Order order);
}
