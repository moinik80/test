//interface for categoryDao

package by.jd2.library.dao;

import by.jd2.library.pojos.Category;

import java.util.List;

public interface ICategoryDao<T> extends  Dao<T> {
    List<String> getCategoriesName();
    List<Category> getCategories();
}
