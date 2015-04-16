//interface for PersonService

package by.jd2.library.services;

import java.util.List;

public interface IPersonService<T> extends IService<T> {
    T getPersonByEmail(String email);
    List<T> getPersons();
}
