package main;


import dao.iml.CustomerDAOIml;
import model.Customer;

import java.sql.Date;


public class Main {
    public static void main(String[] args) {
        CustomerDAOIml customerDAOIml = new CustomerDAOIml();
        Customer customer = new Customer("thao","93763", "nueg@gmail", new Date(1994,11,1));
        System.out.println(customerDAOIml.addCustomer(customer));
        System.out.println(customerDAOIml.getAllCustomers());

    }
}
