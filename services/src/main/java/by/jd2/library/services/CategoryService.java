package by.jd2.library.services;

import by.jd2.library.dao.ICategoryDao;
import by.jd2.library.pojos.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class CategoryService extends BaseService<Category> implements ICategoryService<Category> {

    @Autowired
    ICategoryDao categoryDao;

//    return list Category, use CategoryDao
    @Override
    public List<String> getCategoriesName() {
        return categoryDao.getCategoriesName();
    }

    @Override
    public List<Category> getCategories() {
        return categoryDao.getCategories();
    }
}
