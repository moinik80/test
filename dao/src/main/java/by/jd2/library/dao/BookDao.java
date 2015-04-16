package by.jd2.library.dao;

import by.jd2.library.pojos.Book;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookDao extends BaseDao<Book> implements IBookDao<Book> {

    @Autowired
    public BookDao(SessionFactory sessionFactory){
        super(sessionFactory);
    }


    @Override
    public List<Book> getBooks(String hql, int countResultInt, int startResult) {
        Query query = getSession().createQuery(hql);
        query.setFirstResult(startResult);
        query.setMaxResults(countResultInt);
        return query.list();
    }

    //    return list authors from entity Book from database
    @Override
    public List<String> getAuthors() {
        String hql = "SELECT DISTINCT bookAuthor FROM Book";
        return getSession().createQuery(hql).list();
    }

//    return count book
    @Override
    public long getCountBooks() {
        String hql = "SELECT count(bookName) FROM Book";
        return (long) getSession().createQuery(hql).uniqueResult();
    }
}
