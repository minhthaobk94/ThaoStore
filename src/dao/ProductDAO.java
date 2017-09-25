package dao;

import model.Product;

import java.util.List;

public interface ProductDAO {
    List<Product> getAllProducts();

    Product getProduct(int id);

    int addProduct(Product product);

    int updateProduct(Product product);

    int deleteProduct(Product product);
}
