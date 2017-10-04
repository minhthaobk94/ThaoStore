package dao;

import model.OrderItem;

import java.util.List;

public interface OrderItemDAO {
    List<OrderItem> getAllOrderItems();

    OrderItem getOrderItem(int id);

    int addOrderItem(OrderItem orderItem);

    int updateOrderItem(OrderItem orderItem);

    int deleteOrderItem(OrderItem orderItem);
}
