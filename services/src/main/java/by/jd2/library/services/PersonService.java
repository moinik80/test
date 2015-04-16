package by.jd2.library.services;

import by.jd2.library.dao.IPersonDao;
import by.jd2.library.pojos.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class PersonService extends BaseService<Person> implements IPersonService<Person> {

    @Autowired
    IPersonDao personDao;

//return list Person, use methods for PersonDao
    @Override
    public List<Person> getPersons() {
        return personDao.getPersons();
    }

    @Override
    public Person getPersonByEmail(String email) {
        return (Person) personDao.getPersonByEmail(email);
    }
}
