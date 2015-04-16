//interface for CategoryService

package by.jd2.library.services;

import by.jd2.library.pojos.Category;

import java.util.List;

public interface ICategoryService<T> extends IService<T> {
    List<String> getCategoriesName();
    List<Category> getCategories();
}
