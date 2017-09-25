package model;

import lombok.Data;

import java.sql.Date;

@Data
public class Customer {
    private int id;
    private String customer_name;
    private String phone;
    private String email;
    private Date birthday;

    public Customer() {
    }

    public Customer(String customer_name, String phone, String email, Date birthday) {
        this.customer_name = customer_name;
        this.phone = phone;
        this.email = email;
        this.birthday = birthday;
    }

    public Customer(int id, String customer_name, String phone, String email, Date birthday) {
        this.id = id;
        this.customer_name = customer_name;
        this.phone = phone;
        this.email = email;
        this.birthday = birthday;
    }
}
