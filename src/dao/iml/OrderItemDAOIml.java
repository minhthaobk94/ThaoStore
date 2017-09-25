package dao.iml;

import dao.BaseDAO;
import dao.OrderItemDAO;
import model.OrderItem;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderItemDAOIml extends BaseDAO implements OrderItemDAO {
    @Override
    public List<OrderItem> getAllOrderItems() {
        List<OrderItem> orderItems = null;
        OrderItem orderItem;
        CallableStatement call;
        try {
            call = getConnection().prepareCall("{call sp_getAllOrderItems()}");
            ResultSet rs = call.executeQuery();
            orderItems = new ArrayList<>();
            while (rs.next()) {
                orderItem = new OrderItem();
                orderItem.setOrder(new OrderDAOIml().getOrder(rs.getInt(1)));
                orderItem.setProduct(new ProductDAOIml().getProduct(rs.getInt(2)));
                orderItems.add(orderItem);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderItems;
    }

    @Override
    public OrderItem getOrderItem(int id) {
        CallableStatement call;
        OrderItem orderItem = null;
        try {
            call = getConnection().prepareCall("{call sp_getOrderItem(?)}");
            call.setInt(1, id);
            ResultSet rs = call.executeQuery();
            while (rs.next()) {
                orderItem = new OrderItem();
                orderItem.setOrder(new OrderDAOIml().getOrder(rs.getInt(1)));
                orderItem.setProduct(new ProductDAOIml().getProduct(rs.getInt(2)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderItem;
    }

    @Override
    public int addOrderItem(OrderItem orderItem) {
        CallableStatement call;
        int numOfAffectedRows = 0;
        try {
            call = getConnection().prepareCall("{call sp_addOrderItem(?, ?)}");
            call.setInt(1, orderItem.getOrder().getId());
            call.setInt(2, orderItem.getProduct().getId());
            numOfAffectedRows = call.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return numOfAffectedRows;
    }

    @Override
    public int updateOrderItem(OrderItem orderItem) {
        CallableStatement call;
        int numOfAffectedRows = 0;
        try {
            call = getConnection().prepareCall("{call sp_updateOrderItem(?, ?)}");
            call.setInt(1, orderItem.getOrder().getId());
            call.setInt(2, orderItem.getProduct().getId());
            numOfAffectedRows = call.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return numOfAffectedRows;
    }

    @Override
    public int deleteOrderItem(OrderItem orderItem) {
        CallableStatement call;
        int numOfAffectedRows = 0;
        try {
            call = getConnection().prepareCall("{call sp_deleteOrderItem(?)}");
            call.setInt(1, orderItem.getOrder().getId());
            numOfAffectedRows = call.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return numOfAffectedRows;
    }
}
