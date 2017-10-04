package model;

import lombok.Data;

@Data
public class Product {
    private int id;
    private Category category;
    private String product_name;
    private String description;
    private String imgUrl;
    private  double price;

    public Product() {
    }

    public Product(int id, Category category, String product_name, String description, String imgUrl, double price) {
        this.id = id;
        this.category = category;
        this.product_name = product_name;
        this.description = description;
        this.imgUrl = imgUrl;
        this.price = price;
    }

    public Product(Category category, String product_name, String description, String imgUrl, double price) {
        this.category = category;
        this.product_name = product_name;
        this.description = description;
        this.imgUrl = imgUrl;
        this.price = price;
    }
}
