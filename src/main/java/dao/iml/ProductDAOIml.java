package dao.iml;

import dao.BaseDAO;
import dao.ProductDAO;
import model.Product;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAOIml extends BaseDAO implements ProductDAO {
    @Override
    public List<Product> getAllProducts() {
        List<Product> products = null;
        Product product;
        CallableStatement call;
        try {
            call = getConnection().prepareCall("{call sp_getAllProducts()}");
            ResultSet rs = call.executeQuery();
            products = new ArrayList<>();
            while (rs.next()) {
                CategoryDAOIml categoryDAOIml = new CategoryDAOIml();
                product = new Product();
                product.setId(rs.getInt(1));
                product.setCategory(categoryDAOIml.getCategory(rs.getInt(2)));
                product.setProduct_name(rs.getString(3));
                product.setDescription(rs.getString(4));
                product.setImgUrl(rs.getString(5));
                product.setPrice(rs.getDouble(6));
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public Product getProduct(int id) {
        Product product = null;
        CallableStatement call;
        try {
            call = getConnection().prepareCall("{call sp_getProduct(?)}");
            call.setInt(1, id);
            ResultSet rs = call.executeQuery();
            while (rs.next()) {
                product = new Product();
                CategoryDAOIml categoryDAOIml = new CategoryDAOIml();
                product.setId(rs.getInt(1));
                product.setCategory(categoryDAOIml.getCategory(rs.getInt(2)));
                product.setProduct_name(rs.getString(3));
                product.setDescription(rs.getString(4));
                product.setImgUrl(rs.getString(5));
                product.setPrice(rs.getDouble(6));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public int addProduct(Product product) {
        CallableStatement call;
        int numOfAffectedRows = 0;
        try {
            call = getConnection().prepareCall("{call sp_addProduct(?, ?, ?, ?, ?)}");
            call.setInt(1, product.getCategory().getId());
            call.setString(2, product.getProduct_name());
            call.setString(3, product.getDescription());
            call.setString(4, product.getImgUrl());
            call.setDouble(5, product.getPrice());
            numOfAffectedRows = call.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return numOfAffectedRows;
    }

    @Override
    public int updateProduct(Product product) {
        CallableStatement call;
        int numOfAffectedRows = 0;
        try {
            call = getConnection().prepareCall("{call sp_updateProduct(?, ?, ?, ?, ?, ?)}");
            call.setInt(1, product.getId());
            call.setInt(2, product.getCategory().getId());
            call.setString(3, product.getProduct_name());
            call.setString(4, product.getDescription());
            call.setString(5, product.getImgUrl());
            call.setDouble(6, product.getPrice());
            numOfAffectedRows = call.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return numOfAffectedRows;
    }

    @Override
    public int deleteProduct(Product product) {
        CallableStatement call;
        int numOfAffectedRows = 0;
        try {
            call = getConnection().prepareCall("{call sp_deleteProduct(?)}");
            call.setInt(1, product.getId());
            numOfAffectedRows = call.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return numOfAffectedRows;
    }
}
