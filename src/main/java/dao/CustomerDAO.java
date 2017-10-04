package dao;

import model.Customer;

import java.util.List;

public interface CustomerDAO {

    List<Customer> getAllCustomers();

    Customer getCustomer(int id);

    int addCustomer(Customer customer);

    int updateCustomer(Customer customer);

    int deleteCustomer(Customer customer);
}
