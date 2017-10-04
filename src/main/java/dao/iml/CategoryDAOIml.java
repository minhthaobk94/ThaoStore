package dao.iml;

import dao.BaseDAO;
import dao.CategoryDAO;
import model.Category;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAOIml extends BaseDAO implements CategoryDAO {

    @Override
    public List<Category> getCategories() {
        List<Category> categories = null;
        Category category = null;
        CallableStatement call;

        try {
            call = getConnection().prepareCall("{call sp_getAllCategories()}");
            ResultSet rs = call.executeQuery();
            categories = new ArrayList<Category>();
            while (rs.next()) {
                category = new Category();
                category.setId(rs.getInt(1));
                category.setTitle(rs.getString(2));
                categories.add(category);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categories;
    }

    @Override
    public Category getCategory(int id) {
        Category category = null;
        CallableStatement call;
        try {
            call = getConnection().prepareCall("{call sp_getCategory(?)}");
            call.setInt(1, id);
            ResultSet rs = call.executeQuery();
            while (rs.next()) {
                category = new Category();
                category.setId(rs.getInt(1));
                category.setTitle(rs.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return category;
    }

    @Override
    public int addCategory(Category category) {
        CallableStatement call;
        int numOfAffectedRows = 0;
        try {
            call = getConnection().prepareCall("{call sp_addCategory(?)}");
            call.setString(1, category.getTitle());
            numOfAffectedRows = call.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return numOfAffectedRows;
    }

    @Override
    public int updateCategory(Category category) {
        CallableStatement call;
        int numOfAffectedRows = 0;
        try {
            call = getConnection().prepareCall("{call sp_updateCategory(?, ?)}");
            call.setInt(1, category.getId());
            call.setString(2, category.getTitle());
            numOfAffectedRows = call.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return numOfAffectedRows;
    }

    @Override
    public int deleteCategory(Category category) {
        CallableStatement call;
        int numOfAffectedRows = 0;
        try {
            call = getConnection().prepareCall("{call sp_deleteCategory(?)}");
            call.setInt(1, category.getId());
            numOfAffectedRows = call.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return numOfAffectedRows;
    }
}
