package by.jd2.library.dao;

import by.jd2.library.pojos.Person;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonDao extends BaseDao<Person> implements IPersonDao<Person> {
    @Autowired
    public PersonDao(SessionFactory sessionFactory) {super(sessionFactory);}

//    return list Person from database
    @Override
    public List<Person> getPersons() {
        String hql = "FROM Person";
        return getSession().createQuery(hql).list();
    }

    //    return Person.fio
    @Override
    public Person getPersonByEmail(String email) {
        String hql = "FROM Person WHERE email=:email";
        Query query = getSession().createQuery(hql);

        query.setParameter("email", email);
        return (Person) query.uniqueResult();
    }
}
