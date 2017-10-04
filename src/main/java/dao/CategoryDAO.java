package dao;

import model.Category;

import java.util.List;

public interface CategoryDAO {
    List<Category> getCategories();

    Category getCategory(int id);

    int addCategory(Category category);

    int updateCategory(Category category);

    int deleteCategory (Category category);
}
