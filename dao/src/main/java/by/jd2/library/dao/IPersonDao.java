//interface for PersonDao

package by.jd2.library.dao;

import java.util.List;

/**
 * Created by Иван on 31.03.2015.
 */
public interface IPersonDao<T> extends Dao<T> {
    List<T> getPersons();
    T getPersonByEmail(String email);
}
