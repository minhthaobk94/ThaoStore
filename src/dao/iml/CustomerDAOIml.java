package dao.iml;

import dao.BaseDAO;
import dao.CustomerDAO;
import model.Customer;

import java.sql.Connection;
import java.util.List;

public class CustomerIml extends BaseDAO implements CustomerDAO {
    Connection connection;
    public CustomerIml() {
        connection = getConnection();
    }

    @Override
    public List<Customer> getAllCustomers() {
        return null;
    }

    @Override
    public Customer getCustomer(int id) {
        return null;
    }

    @Override
    public int addCustomer(Customer customer) {
        return 0;
    }

    @Override
    public int updateCustomer(Customer customer) {
        return 0;
    }

    @Override
    public int deleteCustomer(Customer customer) {
        return 0;
    }
}
