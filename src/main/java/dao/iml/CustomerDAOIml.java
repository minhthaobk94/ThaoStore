package dao.iml;

import dao.BaseDAO;
import dao.CustomerDAO;
import model.Customer;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAOIml extends BaseDAO implements CustomerDAO {

    @Override
    public List<Customer> getAllCustomers() {
        List<Customer> customers = null;
        Customer customer = null;
        CallableStatement call;
        try {
            call = getConnection().prepareCall("{call sp_getAllCustomers()}");
            ResultSet rs = call.executeQuery();
            customers = new ArrayList<Customer>();
            while (rs.next()) {
                customer = new Customer();
                customer.setId(rs.getInt(1));
                customer.setCustomer_name(rs.getString(2));
                customer.setPhone(rs.getString(3));
                customer.setEmail(rs.getString(4));
                customer.setBirthday(rs.getDate(5));
                customers.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return customers;
    }

    @Override
    public Customer getCustomer(int id) {
        Customer customer = null;
        CallableStatement call;
        try {
            call = getConnection().prepareCall("{call sp_getCustomer(?)}");
            call.setInt(1, id);
            ResultSet rs = call.executeQuery();
            while (rs.next()) {
                customer = new Customer();
                customer.setId(rs.getInt(1));
                customer.setCustomer_name(rs.getString(2));
                customer.setPhone(rs.getString(3));
                customer.setEmail(rs.getString(4));
                customer.setBirthday(rs.getDate(5));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return customer;
    }

    @Override
    public int addCustomer(Customer customer) {
        CallableStatement call;
        int numOfAffectedRows = 0;
        try {
            call = getConnection().prepareCall("{call sp_addCustomer(?, ?, ?, ?)}");
            call.setString(1, customer.getCustomer_name());
            call.setString(2, customer.getPhone());
            call.setString(3, customer.getEmail());
            call.setDate(4, customer.getBirthday());
            numOfAffectedRows = call.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return numOfAffectedRows;
    }

    @Override
    public int updateCustomer(Customer customer) {
        CallableStatement call;
        int numOfAffectedRows = 0;
        try {
            call = getConnection().prepareCall("{call sp_updateCustomer(?, ?, ?, ?, ?)}");
            call.setInt(1, customer.getId());
            call.setString(2, customer.getCustomer_name());
            call.setString(3, customer.getPhone());
            call.setString(4, customer.getEmail());
            call.setDate(5, customer.getBirthday());
            numOfAffectedRows = call.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return numOfAffectedRows;
    }

    @Override
    public int deleteCustomer(Customer customer) {
        CallableStatement call;
        int numOfAffectedRows = 0;
        try {
            call = getConnection().prepareCall("{call sp_deleteCustomer(?)}");
            call.setInt(1, customer.getId());
            numOfAffectedRows = call.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return numOfAffectedRows;
    }
}
