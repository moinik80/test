package by.jd2.library.dao;

import by.jd2.library.pojos.Category;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryDao extends BaseDao<Category> implements ICategoryDao<Category>{
    @Autowired
    public CategoryDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

//    return list Category from database
    @Override
    public List<String> getCategoriesName() {
        String hql = " SELECT DISTINCT categoryName FROM Category";
        return getSession().createQuery(hql).list();
    }

    @Override
    public List<Category> getCategories() {
        String hql = " FROM Category";
        return getSession().createQuery(hql).list();
    }
}
