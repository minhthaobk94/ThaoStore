package dao.iml;

import dao.BaseDAO;
import dao.OrderDAO;
import model.Order;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDAOIml extends BaseDAO implements OrderDAO {
 
    public List<Order> getAllOrders() {
        CallableStatement call;
        List<Order> orders = null;
        Order order = null;
        try {
            call = getConnection().prepareCall("{call sp_getAllOrders()}");
            ResultSet rs = call.executeQuery();
            orders = new ArrayList<Order>();
            while (rs.next()) {
                order = new Order();
                CustomerDAOIml customerDAOIml = new CustomerDAOIml();
                order.setId(rs.getInt(1));
                order.setCustomer(customerDAOIml.getCustomer(rs.getInt(2)));
                order.setShipping_address(rs.getString(3));
                order.setTotal(rs.getDouble(4));
                order.setNote(rs.getString(5));
                order.setCreated(rs.getTimestamp(6));
                orders.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }

     
    public Order getOrder(int id) {
        CallableStatement call;
        Order order = null;

        try {
            call = getConnection().prepareCall("{call sp_getOrder(?)}");
            call.setInt(1, id);
            ResultSet rs = call.executeQuery();
            while (rs.next()) {
                order = new Order();
                CustomerDAOIml customerDAOIml = new CustomerDAOIml();
                order.setId(rs.getInt(1));
                order.setCustomer(customerDAOIml.getCustomer(rs.getInt(2)));
                order.setShipping_address(rs.getString(3));
                order.setTotal(rs.getDouble(4));
                order.setNote(rs.getString(5));
                order.setCreated(rs.getTimestamp(6));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return order;
    }

     
    public int addOrder(Order order) {
        CallableStatement call;
        int numOfAffectedRows = 0;
        try {
            call = getConnection().prepareCall("{call sp_addOrder(?, ?, ?, ?, ?)}");
            call.setInt(1, order.getCustomer().getId());
            call.setString(2, order.getShipping_address());
            call.setDouble(3, order.getTotal());
            call.setString(4, order.getNote());
            call.setTimestamp(5, order.getCreated());
            numOfAffectedRows = call.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return numOfAffectedRows;
    }

     
    public int updateOrder(Order order) {
        CallableStatement call;
        int numOfAffectedRows = 0;
        try {
            call = getConnection().prepareCall("{call sp_updateOrder(?, ?, ?, ?, ?, ?)}");
            call.setInt(1, order.getId());
            call.setInt(2, order.getCustomer().getId());
            call.setString(3, order.getShipping_address());
            call.setDouble(4, order.getTotal());
            call.setString(5, order.getNote());
            call.setTimestamp(6, order.getCreated());
            numOfAffectedRows = call.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return numOfAffectedRows;
    }

     
    public int deleteOrder(Order order) {
        CallableStatement call;
        int numOfAffectedRows = 0;

        try {
            call = getConnection().prepareCall("{call sp_deleteOrder(?)}");
            call.setInt(1, order.getId());
            numOfAffectedRows = call.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return numOfAffectedRows;
    }
}
